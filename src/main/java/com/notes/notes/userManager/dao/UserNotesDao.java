package com.notes.notes.userManager.dao;

import com.notes.notes.userManager.model.UserNotes;

import java.util.List;

public interface UserNotesDao {

     void addNotes(UserNotes userNotes);

     List<UserNotes> getAll();

     UserNotes getById(int id);

     UserNotes updateNotes(int id, UserNotes userNotes);

     void deleteNotes(int id);

     List<UserNotes> searchNotes(String title, String description);
}
