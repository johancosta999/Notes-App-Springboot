package com.johan.notesapp.controller;

import com.johan.notesapp.model.Note;
import com.johan.notesapp.service.NoteService;
//controller validation imports
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("notes", noteService.getAllNotes());
        model.addAttribute("note", new Note());
        return "index";
    }

    @PostMapping("/save")
    public String saveNote(@Valid @ModelAttribute("note") Note note, BindingResult result, Model model){
        // If validation fails, redisplay the form and keep the note list visible.
        if(result.hasErrors()){
            model.addAttribute("notes", noteService.getAllNotes());
            return "index";
        }
        noteService.saveNote(note);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String editNote(@PathVariable Long id, Model model){
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "updateNote";
    }

    @PostMapping("/update/{id}")
    public String updateNote(@PathVariable Long id,@Valid @ModelAttribute("note") Note note, BindingResult result) {
        note.setId(id);

        // If validation fails, stay on the edit page so the user can fix the fields.
        if(result.hasErrors()){
            return "updateNote";
        }

        noteService.saveNote(note);
        return "redirect:/";
    }
}





