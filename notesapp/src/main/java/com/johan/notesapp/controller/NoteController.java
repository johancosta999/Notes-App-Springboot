package com.johan.notesapp.controller;

import com.johan.notesapp.model.Note;
import com.johan.notesapp.service.NoteService;
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
    public String saveNote(@ModelAttribute Note note){
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
        model.addAttribute("note", noteService.getNoteById(id));
        return "updateNote";
    }

    @PostMapping("/update/{id}")
    public String updateNote(@PathVariable Long id, @ModelAttribute Note note) {

        note.setId(id);

        noteService.saveNote(note);

        return "redirect:/";
    }
}
