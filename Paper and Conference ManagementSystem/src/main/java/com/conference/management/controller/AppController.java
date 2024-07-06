package com.conference.management.controller;

import com.conference.management.service.IPaperAssignmentService;
import com.conference.management.service.IPaperService;
import com.conference.management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AppController {

    private IUserService userService;

    private IPaperService paperService;

    private IPaperAssignmentService paperAssignmentService;

    @Value("${myFilePath}")
    private String myFilePath;

    @Autowired
    public AppController(IUserService userService, IPaperService paperService, IPaperAssignmentService paperAssignmentService) {
        this.userService = userService;
        this.paperService = paperService;
        this.paperAssignmentService = paperAssignmentService;
    }

    @GetMapping("/home")
    public String home(){
        return "home-page";
    }

}
