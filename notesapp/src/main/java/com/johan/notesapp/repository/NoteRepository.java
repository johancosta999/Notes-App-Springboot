package com.johan.notesapp.repository;

import com.johan.notesapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoteRepository extends JpaRepository<Note,Long> {}

