package com.conference.management.service;

import com.conference.management.entity.Paper;

import java.util.List;

public interface IPaperService {
    void save(Paper paper);

    Paper getById(int id);

    List<Paper> getAll();

    List<Paper> getPapersByField(String field);

    List<Paper> getByReviewer(int id);

    void update(Paper paper);

    void delete(int id);

    List<Paper> getByAuthor(int id);

    void assignPaper(Paper paper);

    List<Paper> getAllApprovedPapers();

}
