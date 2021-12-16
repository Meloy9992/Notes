package com.notes.notes.userManager.model;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class UserNotes {


    @Id
    @Column(name = "id_notes")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserNotes(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public UserNotes() {
    }
}
