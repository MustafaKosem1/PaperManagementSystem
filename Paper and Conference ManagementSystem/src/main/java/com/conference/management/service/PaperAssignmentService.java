package com.conference.management.service;

import com.conference.management.entity.Paper;
import com.conference.management.entity.PaperAssignment;
import com.conference.management.entity.Profession;
import com.conference.management.repository.IPaperAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaperAssignmentService implements IPaperAssignmentService{

    private IPaperAssignmentRepository paperAssignmentRepository;
    private IPaperService paperService;

    @Autowired
    public PaperAssignmentService(IPaperAssignmentRepository paperAssignmentRepository, IPaperService paperService) {
        this.paperAssignmentRepository = paperAssignmentRepository;
        this.paperService = paperService;
    }

    @Override
    public void update(PaperAssignment assignment) {
        paperAssignmentRepository.update(assignment);
    }

    @Override
    public PaperAssignment getById(int id) {
        return paperAssignmentRepository.getById(id);
    }

    @Transactional
    @Override
    public void evaluatePaperForAssignment(PaperAssignment assignment) {
        PaperAssignment paperAssignment= paperAssignmentRepository.getById(assignment.getId());
        paperAssignment.setFeedback(assignment.getFeedback());
        paperAssignment.setReturn_date(LocalDate.now());
        paperAssignment.setScore(assignment.getScore());
        if(paperAssignment.getScore()>=80){
            paperAssignment.setResult("Onaylandı.");
        }
        else{
            paperAssignment.setResult("Reddedildi.");
        }
        if(paperAssignment.getResult()!="Revizyon."){
            paperAssignment.setState("Tamamlandı.");
            paperAssignment.getPaper().setState("Sonuçlandı.");
            paperAssignment.getReviewer().setIs_reviewer_has_not_assignment(true);
        }
        else{
            paperAssignment.setState("Revize bekleniyor.");
            paperAssignment.getPaper().setState("Revize bekleniyor.");
        }
        paperAssignmentRepository.update(paperAssignment);

        paperAssignmentAfterEvaluate(paperAssignment.getReviewer().getProfessions());
    }

    @Override
    public void paperAssignmentAfterEvaluate(List<Profession> professions) {
        List<Paper> papers_to_new_assignment=new ArrayList<>();
        for (Profession profession:professions) {
            papers_to_new_assignment.addAll(paperService.getPapersByField(profession.getName()));
        }
        if(!papers_to_new_assignment.isEmpty()){
            Paper oldest_paper=papers_to_new_assignment.get(0);
            for (Paper paper:papers_to_new_assignment) {
                if(paper.getUpload_date().compareTo(oldest_paper.getUpload_date())<0){
                    oldest_paper=paper;
                }
            }
            paperService.assignPaper(oldest_paper);
        }
    }

    @Override
    public void paperAssignmentRevisionRequest(PaperAssignment assignment) {
        PaperAssignment paperAssignment= paperAssignmentRepository.getById(assignment.getId());
        paperAssignment.setFeedback(assignment.getFeedback());
        paperAssignment.setReturn_date(LocalDate.now());
        paperAssignment.setScore(assignment.getScore());
        paperAssignment.setResult("Revizyon.");
        paperAssignment.setState("Revize bekleniyor.");
        paperAssignment.getPaper().setState("Revize bekleniyor.");
        paperAssignmentRepository.update(paperAssignment);
    }
}
