package com.notes.notes.userManager.services.impl;

import com.notes.notes.userManager.dao.UserNotesDao;
import com.notes.notes.userManager.model.UserNotes;
import com.notes.notes.userManager.services.UserNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNotesServiceImpl implements UserNotesService {

    private UserNotesDao userNotesDao;

    @Autowired
    public UserNotesServiceImpl(UserNotesDao userNotesDao) {
        this.userNotesDao = userNotesDao;
    }

    @Override
    public void addNotes(UserNotes userNotes) {
        userNotesDao.addNotes(userNotes);
    }

    @Override
    public List<UserNotes> getAll() {
        return userNotesDao.getAll();
    }

    @Override
    public UserNotes getById(int id) {
        return userNotesDao.getById(id);
    }

    @Override
    public UserNotes updateNotes(int id, UserNotes userNotes) {
        return userNotesDao.updateNotes(id, userNotes);
    }

    @Override
    public void deleteNotes(int id) {
        userNotesDao.deleteNotes(id);
    }

    @Override
    public void createNotes(String title, String description) {
        UserNotes userNotes = new UserNotes(title, description);
        addNotes(userNotes);
    }

    @Override
    public List<UserNotes> searchNotes(String title, String description) {
        return userNotesDao.searchNotes(title, description);
    }
}
