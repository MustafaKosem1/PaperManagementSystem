package com.conference.management.repository;

import com.conference.management.entity.PaperAssignment;

public interface IPaperAssignmentRepository {
    void update(PaperAssignment assignment);
    PaperAssignment getById(int id);
}
