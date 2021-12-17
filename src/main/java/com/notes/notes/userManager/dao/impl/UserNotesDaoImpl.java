package com.notes.notes.userManager.dao.impl;

import com.notes.notes.userManager.dao.UserNotesDao;
import com.notes.notes.userManager.model.UserNotes;
import com.notes.notes.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserNotesDaoImpl implements UserNotesDao {


    @Override
    public void addNotes(UserNotes userNotes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(userNotes);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<UserNotes> getAll() {
        try{
            Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserNotes.class);
            List<UserNotes> notesList = criteria.list();
            return notesList;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    @Override
    public UserNotes getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UserNotes userNotes = (UserNotes) session.createQuery("FROM UserNotes WHERE id = " + id).list().get(0);
        session.close();
        return userNotes;
    }

    @Override
    public UserNotes updateNotes(int id, UserNotes userNotes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UserNotes originalNotes = getById(id);
        if (originalNotes != null){
            session.beginTransaction();
            originalNotes.setTitle(userNotes.getTitle());
            originalNotes.setDescription(userNotes.getDescription());
            session.saveOrUpdate(originalNotes);
            session.getTransaction().commit();
        }
        session.close();
        return originalNotes;
    }

    @Override
    public void deleteNotes(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UserNotes userNotes = getById(id);
        session.delete(userNotes);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<UserNotes> searchNotes(String title, String description) {
        Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserNotes.class);

        if (title != null && !title.equals("")){
            criteria.add(Restrictions.like("title", title ));
        }

        if (description != null && !description.equals("")){
            criteria.add(Restrictions.like("description", description));
        }

        return criteria.list();
    }
}
