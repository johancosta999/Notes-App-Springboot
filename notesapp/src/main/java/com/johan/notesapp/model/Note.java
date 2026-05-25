package com.johan.notesapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;
    private String content;

    public Note(){
    }

    public Note(String title, String content) {
        this.title =title;
        this.content=content;
    }

}
