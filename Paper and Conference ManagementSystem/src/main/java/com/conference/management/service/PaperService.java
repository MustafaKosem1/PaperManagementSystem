package com.conference.management.service;

import com.conference.management.entity.Paper;
import com.conference.management.entity.PaperAssignment;
import com.conference.management.entity.User;
import com.conference.management.repository.IPaperRepository;
import com.conference.management.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PaperService implements IPaperService{

    private IPaperRepository paperRepository;

    private IUserRepository userRepository;

    @Autowired
    public PaperService(IPaperRepository paperRepository, IUserRepository userRepository) {
        this.paperRepository = paperRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void assignPaper(Paper paper){
        boolean assignmentNumberIsThree=false;
        boolean alreadyAssigned=false;
        List<User> users=userRepository.getViewersForAssignment(paper.getPaper_field(), paper.getAuthor().getId());
        if(!users.isEmpty()){
            if(paper.getPaper_assignments()!=null && !paper.getPaper_assignments().isEmpty()){
                if(paper.getPaper_assignments().size()<3){
                    for (PaperAssignment paperAssignment: paper.getPaper_assignments()) {
                        if(paperAssignment.getResult()!=null){
                            if(paperAssignment.getResult().equals("Onaylandı.") || paperAssignment.getState().equals("İncele aşamasında.") || paperAssignment.getState().equals("Revize bekleniyor.")){
                                alreadyAssigned=true;
                            }
                        }
                        else {
                            alreadyAssigned=true;
                        }
                    }
                    paper.getPaper_assignments().forEach(paperAssignment -> users.removeIf(user -> user.getId() == paperAssignment.getReviewer().getId()));
                }
                else{
                    assignmentNumberIsThree=true;
                }
            }
            if(!assignmentNumberIsThree && !alreadyAssigned && !users.isEmpty()){
                paper.setState("Bir reviewera atandı.");
                Random random= new Random();
                User user=users.get(random.nextInt(users.size()));
                PaperAssignment paperAssignment=new PaperAssignment();
                paperAssignment.setPaper(paper);
                paperAssignment.setAssignment_date(LocalDate.now());
                paperAssignment.setReviewer(user);
                paperAssignment.setState("İncele aşamasında.");
                if(paper.getPaper_assignments()==null){
                    List<PaperAssignment> paperAssignmentList= new ArrayList<>();
                    paper.setPaper_assignments(paperAssignmentList);
                }
                paper.getPaper_assignments().add(paperAssignment);
                update(paper);
                user.setIs_reviewer_has_not_assignment(false);
                userRepository.update(user);
            }
            else {
                paper.setState("Atama Bekliyor.");
                update(paper);
            }
        }
        else{
            paper.setState("Atama Bekliyor.");
            update(paper);
        }
    }

    @Override
    public List<Paper> getAllApprovedPapers() {
        return paperRepository.getAllApprovedPapers();
    }


    @Override
    public void save(Paper paper) {
        paper.setState("Atama Bekliyor.");
        paperRepository.save(paper);
        assignPaper(paper);
    }

    @Override
    public Paper getById(int id) {
        return paperRepository.getById(id);
    }

    @Override
    public List<Paper> getAll() {
        return paperRepository.getAll();
    }

    @Override
    public List<Paper> getPapersByField(String field) {
        return paperRepository.getPapersByField(field);
    }

    @Override
    public List<Paper> getByReviewer(int id) {
        List<Paper> papers=paperRepository.getByReviewer(id);
        for (Paper paper:papers) {
            if(paper.getPaper_assignments()!=null) {
                paper.getPaper_assignments().removeIf(paperAssignment -> paperAssignment.getReviewer().getId() != id);
            }
        }
        return papers;
    }

    @Override
    public void update(Paper paper) {
        paperRepository.update(paper);
    }

    @Override
    public void delete(int id) {
        paperRepository.delete(id);
    }

    @Override
    public List<Paper> getByAuthor(int id) {
        return paperRepository.getByAuthor(id);
    }
}
