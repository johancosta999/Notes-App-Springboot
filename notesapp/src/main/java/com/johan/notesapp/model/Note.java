package com.johan.notesapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank(message="Title is required")
    @Size(max=50, message="Title must be maximum 50 characters")
    private String title;

    @NotBlank(message="Content cannot be empty")
    @Size(max=500, message="Content must be maximum 500 characters")
    private String content;

    public Note(){
    }

    public Note(String title, String content) {
        this.title =title;
        this.content=content;
    }

}
