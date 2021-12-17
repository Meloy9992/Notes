package com.notes.notes.controllers;

import com.notes.notes.userManager.model.UserNotes;
import com.notes.notes.userManager.services.UserNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotesController {

    private UserNotesService userNotesService;

    @Autowired
    public NotesController(UserNotesService userNotesService) {
        this.userNotesService = userNotesService;
    }

    @GetMapping("/viewNotes")
    public String viewNotes (Model model) throws InterruptedException {
        model.addAttribute("notes", userNotesService.getAll());
        return "viewNotes";
    }

    @GetMapping("/searchNotes")
    public String searchNotes(Model model){
        return "searchNotes";
    }

    @GetMapping("/notesById")
    public String getNotes(@RequestParam int id, Model model) {
        model.addAttribute("element", userNotesService.getById(id));
        return "editNotes";
    }

    @GetMapping("/editNotes")
    public String displayNotes(@RequestParam int id, Model model){
        return "redirect:/notesById?id=" + id;
    }

    @PostMapping("/notesById")
    public String editNote(@RequestParam int id, @RequestParam String title, @RequestParam String description, Model model){
        model.addAttribute("editNotes", userNotesService.updateNotes(id, new UserNotes(title, description)));
        return "redirect:/viewNotes";
    }

    @GetMapping("/deleteNotes")
    public String deleteNote(@RequestParam int id){
        userNotesService.deleteNotes(id);
        return "home";
    }

    @PostMapping("/searchNotes")
    public String search(@RequestParam String title, @RequestParam String description, Model model){
        model.addAttribute("notes",userNotesService.searchNotes(title, description) );
        return "searchNotes";
    }
}
