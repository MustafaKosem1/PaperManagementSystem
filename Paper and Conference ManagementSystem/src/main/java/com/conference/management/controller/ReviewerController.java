package com.conference.management.controller;

import com.conference.management.entity.Paper;
import com.conference.management.entity.PaperAssignment;
import com.conference.management.entity.User;
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
public class ReviewerController {

    private IUserService userService;

    private IPaperService paperService;

    private IPaperAssignmentService paperAssignmentService;

    @Autowired
    public ReviewerController(IUserService userService, IPaperService paperService, IPaperAssignmentService paperAssignmentService) {
        this.userService = userService;
        this.paperService = paperService;
        this.paperAssignmentService = paperAssignmentService;
    }

    @GetMapping("/reviewer/setAssignmentEnable")
    public String setReviewerAssignmentEnable(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByMail(authentication.getName());
        userService.setReviewerAssignmentEnable(user);
        return "redirect:/home/paper/myAssignments";
    }

    @GetMapping("/paper/myAssignments")
    public String showPaperToReviewer(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        int id = userService.getByMail(authentication.getName()).getId();

        List<Paper> paperList;
        paperList=paperService.getByReviewer(id);
        model.addAttribute("paper_list", paperList);
        model.addAttribute("reviewer", userService.getById(id));
        return "reviewer-all-assignment-page";
    }

    @GetMapping("/paper/evaluate/{id}")
    public String paperEvaluate(Model model, @PathVariable("id") int id){
        PaperAssignment assignment= paperAssignmentService.getById(id);
        model.addAttribute("assignment",assignment );
        model.addAttribute("paper",assignment.getPaper());
        return "reviewer-evaluate-assignment-page";
    }

    @PostMapping("/paper/evaluate/process")
    public String paperEvaluateProcess(@ModelAttribute("assignment") PaperAssignment assignment){
        paperAssignmentService.evaluatePaperForAssignment(assignment);
        return "paper-evaluation-confirm-page";
    }
}