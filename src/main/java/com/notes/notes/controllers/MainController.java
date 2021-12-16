package com.notes.notes.controllers;

import com.notes.notes.userManager.model.UserNotes;
import com.notes.notes.userManager.services.UserNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private UserNotesService userNotesService;

    @Autowired
    public MainController(UserNotesService userNotesService) {
        this.userNotesService = userNotesService;
    }

    @GetMapping("/")
    private String home(Model model){
        model.addAttribute("Title", "Главная страница");
        return "home";
    }

    @PostMapping("/")
    public String userNote(@RequestParam String title, @RequestParam String description){
        if (title != null && title != "") {
            userNotesService.createNotes(title, description);
           // return "redirect:/viewNotes";
        }
        return "home";
    }

}
