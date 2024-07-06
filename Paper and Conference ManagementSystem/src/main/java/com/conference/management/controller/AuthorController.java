package com.conference.management.controller;

import com.conference.management.entity.Paper;
import com.conference.management.entity.PaperAssignment;
import com.conference.management.service.IPaperAssignmentService;
import com.conference.management.service.IPaperService;
import com.conference.management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class AuthorController {

    private IUserService userService;

    private IPaperService paperService;

    private IPaperAssignmentService paperAssignmentService;

    @Autowired
    public AuthorController(IUserService userService, IPaperService paperService, IPaperAssignmentService paperAssignmentService) {
        this.userService = userService;
        this.paperService = paperService;
        this.paperAssignmentService = paperAssignmentService;
    }

    @PostMapping("/paper/revisionRequest")
    public String paperRevisionRequest(@ModelAttribute("assignment") PaperAssignment assignment){
        paperAssignmentService.paperAssignmentRevisionRequest(assignment);
        return "paper-evaluation-confirm-page";
    }

    @GetMapping("/paper/reEvaluateRequest/{id}")
    public String paperReEvaluateRequest(@PathVariable("id") int id){
        Paper paper=paperService.getById(id);
        paperService.assignPaper(paper);
        return "paper-reevaluate-confirm-page";
    }

    @GetMapping("/paper/myPaper")
    public String showPaperToAuthor(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        int id = userService.getByMail(authentication.getName()).getId();

        List<Paper> paperList;
        paperList=paperService.getByAuthor(id);

        boolean[] flag=new boolean[paperList.size()];
        int index=0;

        for (Paper paper:paperList) {
            flag[index]=true;
            if(paper.getState().equals("Atama Bekliyor.")){
                flag[index]=false;
            }
            if(paper.getPaper_assignments()!=null && !paper.getPaper_assignments().isEmpty()){
                if(paper.getPaper_assignments().size()<3){
                    for (PaperAssignment paperAssignment: paper.getPaper_assignments()) {
                        if(paperAssignment.getResult()!=null){
                            if(paperAssignment.getResult().equals("Onaylandı.") || paperAssignment.getState().equals("İncele aşamasında.") || paperAssignment.getState().equals("Revize bekleniyor.")){
                                flag[index]=false;
                            }
                        }
                        else{
                            flag[index]=false;
                        }
                    }
                }
                else{
                    flag[index]=false;
                }
            }
            else{
                flag[index]=false;
            }
            index++;
        }

        model.addAttribute("paper_list", paperList);
        model.addAttribute("flag",flag);
        return "author-all-paper-page";
    }

}
