package com.conference.management.repository;


import com.conference.management.entity.PaperAssignment;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PaperAssignmentRepository implements IPaperAssignmentRepository{

    private EntityManager entityManager;

    @Autowired
    public PaperAssignmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void update(PaperAssignment assignment) {
        entityManager.merge(assignment);
    }

    public PaperAssignment getById(int id) {
        PaperAssignment assignment=entityManager.find(PaperAssignment.class, id);
        return assignment;
    }
}
