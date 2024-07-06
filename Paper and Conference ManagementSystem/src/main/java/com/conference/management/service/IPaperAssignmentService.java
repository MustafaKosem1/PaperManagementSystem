package com.conference.management.service;

import com.conference.management.entity.PaperAssignment;
import com.conference.management.entity.Profession;

import java.util.List;

public interface IPaperAssignmentService {
    void update(PaperAssignment assignment);
    PaperAssignment getById(int id);

    void evaluatePaperForAssignment(PaperAssignment assignment);

    void paperAssignmentAfterEvaluate(List<Profession> professions);

    void paperAssignmentRevisionRequest(PaperAssignment assignment);
}
