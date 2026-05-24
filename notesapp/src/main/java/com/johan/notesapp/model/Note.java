package com.johan.notesapp.model;

import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setContent(String content){
        this.content=content;
    }
}
