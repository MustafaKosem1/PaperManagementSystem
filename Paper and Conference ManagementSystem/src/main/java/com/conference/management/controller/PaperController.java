package com.conference.management.controller;

import com.conference.management.dto.PaperDto;
import com.conference.management.entity.Paper;
import com.conference.management.entity.PaperAssignment;
import com.conference.management.entity.PaperFile;
import com.conference.management.service.IPaperAssignmentService;
import com.conference.management.service.IPaperService;
import com.conference.management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/home")
public class PaperController {

    private IUserService userService;

    private IPaperService paperService;

    private IPaperAssignmentService paperAssignmentService;

    @Value("${myFilePath}")
    private String myFilePath;

    @Autowired
    public PaperController(IUserService userService, IPaperService paperService, IPaperAssignmentService paperAssignmentService) {
        this.userService = userService;
        this.paperService = paperService;
        this.paperAssignmentService = paperAssignmentService;
    }

    @GetMapping("/paper/all")
    public String returnAllPapers(Model model){
        List<Paper> paperList=paperService.getAllApprovedPapers();
        model.addAttribute("paper_list",paperList);
        return "all-paper-page";
    }

    @GetMapping("/paper/assignment/details/{id}")
    public String showPaperAssignmentDetails(Model model, @PathVariable("id") int id){
        PaperAssignment assignment= paperAssignmentService.getById(id);
        model.addAttribute("assignment",assignment );
        model.addAttribute("paper",assignment.getPaper());
        return "assignment-details-page";
    }

    @GetMapping("/paper/save")
    public String paperAddPage(Model model){
        model.addAttribute("paper", new PaperDto());
        return "paper-add-form-page";
    }

    @PostMapping("/paper/save/process")
    public String paperSaveProcess(@ModelAttribute("paper") PaperDto paperDto, @RequestParam("file") List<MultipartFile> files,
                                   @RequestParam(value = "newKeywords", required = false) List<String> newKeywords,
                                   @RequestParam(value = "newSources", required = false) List<String> newSources){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        int id = userService.getByMail(authentication.getName()).getId();
        Paper paper = paperDto.convertToPaper(new Paper(), id, newKeywords, newSources);

        for(MultipartFile file: files) {
            try {
                String filePath = StringUtils.cleanPath(java.util.UUID.randomUUID().toString()) + "_"
                        + file.getOriginalFilename();

                file.transferTo(new File(myFilePath +filePath));

                PaperFile paperFile= new PaperFile();
                paperFile.setFile_location(filePath);
                paper.addPaperFileToPaper(paperFile);

                paperFile.setFile_owner_paper(paper);

            } catch (IOException | IllegalStateException e) {
                e.printStackTrace();
            }
        }
        paperService.save(paper);

        return "paper-upload-confirm-page";
    }

    @PostMapping("/paper/revision/process")
    public String paperRevisionUpdate(@ModelAttribute("paper") Paper paper, @RequestParam("file") List<MultipartFile> files,
                                      @RequestParam(value = "newKeywords", required = false) List<String> newKeywords,
                                      @RequestParam(value = "newSources", required = false) List<String> newSources){
        Paper paper_to_save=paperService.getById(paper.getId());
        paper_to_save.setPaper_field(paper.getPaper_field());
        paper_to_save.setSummary(paper.getSummary());
        paper_to_save.setTitle(paper.getTitle());

        paper_to_save.setState("Bir reviewera atandı.");
        for (PaperAssignment paperAssignment: paper_to_save.getPaper_assignments()) {
            if(paperAssignment.getState().equals("Revize bekleniyor.")){
                paperAssignment.setState("İncele aşamasında.");
                paperAssignment.setResult(null);
            }
        }

        paper_to_save.changeKeywords(newKeywords);
        paper_to_save.changeSources(newSources);

        paper_to_save.setPaper_files(null);

        for(MultipartFile file: files) {
            try {
                String filePath = StringUtils.cleanPath(java.util.UUID.randomUUID().toString()) + "_"
                        + file.getOriginalFilename();

                file.transferTo(new File(myFilePath +filePath));

                PaperFile paperFile= new PaperFile();
                paperFile.setFile_location(filePath);
                paper_to_save.addPaperFileToPaper(paperFile);

                paperFile.setFile_owner_paper(paper_to_save);

            } catch (IOException | IllegalStateException e) {
                e.printStackTrace();
            }
        }
        paperService.update(paper_to_save);
        return "paper-revision-confirm-page";
    }
}