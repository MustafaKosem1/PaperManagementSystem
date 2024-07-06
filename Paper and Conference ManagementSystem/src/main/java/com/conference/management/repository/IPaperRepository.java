package com.conference.management.repository;

import com.conference.management.entity.Paper;

import java.util.List;

public interface IPaperRepository {
    void save(Paper paper);

    Paper getById(int id);

    List<Paper> getAll();

    List<Paper> getPapersByField(String field);

    List<Paper> getByReviewer(int id);

    void update(Paper paper);

    void delete(int id);

    List<Paper> getByAuthor(int id);

    List<Paper> getAllApprovedPapers();
}
