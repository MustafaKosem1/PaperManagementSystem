package com.conference.management.service;

import com.conference.management.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    void save(User user);

    User getById(int id);

    List<User> getAll();

    void update(User user);

    void delete(int id);

    User getByMail(String mail);

    List<User> getViewersForAssignment(String field, int author_id);

    void setReviewerAssignmentEnable(User user);

}
