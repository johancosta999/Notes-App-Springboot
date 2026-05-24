package com.johan.notesapp.servive;

import com.johan.notesapp.model.Note;
import com.johan.notesapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void saveNote(Note note){
        noteRepository.save(note);
    }

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public void deleteNote(Long id){
        noteRepository.deleteById(id);
    }

}
