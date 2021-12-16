package com.notes.notes.userManager.services;

import com.notes.notes.userManager.model.UserNotes;

import java.util.List;

public interface UserNotesService {
    void addNotes(UserNotes userNotes);

    List<UserNotes> getAll();

    UserNotes getById(int id);

    UserNotes updateNotes(int id, UserNotes userNotes);

    void deleteNotes(int id);

    void createNotes(String title, String description);

    List<UserNotes> searchNotes(String title, String description);
}
