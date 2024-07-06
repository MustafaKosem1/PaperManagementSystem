package com.conference.management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "paper_assignment")
public class PaperAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paper_id")
    private Paper paper;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reviewer_id")
    private User reviewer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name="assignment_date")
    private LocalDate assignment_date;

    @Column(name = "score")
    private int score;

    @Column(name="result")
    private String result;

    @Column(name="state")
    private String state;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name="return_date")
    private LocalDate return_date;

    @Column(name="feedback")
    private String feedback;

    public PaperAssignment(){}

    public PaperAssignment(Paper paper, User reviewer, LocalDate assignment_date, int score, String result, String state, LocalDate return_date, String feedback) {
        this.paper = paper;
        this.reviewer = reviewer;
        this.assignment_date = assignment_date;
        this.score = score;
        this.result = result;
        this.state = state;
        this.return_date = return_date;
        this.feedback = feedback;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public LocalDate getAssignment_date() {
        return assignment_date;
    }

    public void setAssignment_date(LocalDate assignment_date) {
        this.assignment_date = assignment_date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "PaperAssignment{" +
                "id=" + id +
                ", paper=" + paper +
                ", reviewer=" + reviewer +
                ", assignment_date=" + assignment_date +
                ", score=" + score +
                ", result='" + result + '\'' +
                ", state='" + state + '\'' +
                ", return_date=" + return_date +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
