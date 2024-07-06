package com.conference.management.repository;

import com.conference.management.entity.User;

import java.util.List;

public interface IUserRepository {
    void save(User user);

    User getById(int id);

    List<User> getAll();

    void update(User user);

    void delete(int id);

    User getByMail(String mail);

    List<User> getViewersForAssignment(String field, int author_id);
}
