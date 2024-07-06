package com.conference.management.repository;

import com.conference.management.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository{
    private EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getById(int id) {
        User user=entityManager.find(User.class, id);
        return user;
    }

    @Override
    public List<User> getViewersForAssignment(String paper_field, int author_id){
        TypedQuery<User> query = entityManager.createQuery(
                "select u " +
                        "from User u " +
                        "JOIN u.professions p " +
                        "WHERE u.enabled = true " +
                        "AND u.is_reviewer_enable_to_review = true " +
                        "AND u.is_reviewer_has_not_assignment = true " +
                        "AND u.id <> :author_id " +
                        "AND p.name = :professionName", User.class);
        query.setParameter("professionName", paper_field);
        query.setParameter("author_id", author_id);
        List<User> userList = query.getResultList();
        return userList;
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> query=entityManager.createQuery("select u from User u", User.class);
        List<User> userList=query.getResultList();
        return userList;
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        User user=getById(id);
        entityManager.remove(user);
    }

    @Override
    public User getByMail(String mail) {
        TypedQuery<User> query=entityManager.createQuery("from User where mail=:data",User.class);
        query.setParameter("data",mail);
        return query.getSingleResult();
    }
}
