package com.notes.notes.controllers;

import com.notes.notes.userManager.services.UserNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotesController {

    private UserNotesService userNotesService;

    @Autowired
    public NotesController(UserNotesService userNotesService) {
        this.userNotesService = userNotesService;
    }

    @GetMapping("/viewNotes")
    public String viewNotes (Model model){
        model.addAttribute("notes", userNotesService.getAll());
        return "viewNotes";
    }

    @GetMapping("/searchNotes")
    public String searchNotes(Model model){
        return "searchNotes";
    }

    @PostMapping("/searchNotes")
    public String search(@RequestParam String title, @RequestParam String description, Model model){
        model.addAttribute("notes",userNotesService.searchNotes(title, description) );
        return "searchNotes";
    }
}
