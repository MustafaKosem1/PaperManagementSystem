package com.conference.management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paper")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "paper")
    private List<Keyword> keywords;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "file_owner_paper")
    private List<PaperFile> paper_files;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "paper")
    private List<Source> sources;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name="upload_date")
    private LocalDate upload_date;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "paper")
    private List<PaperAssignment> paper_assignments;

    @Column(name = "field")
    private String paper_field;

    @Column(name="state")
    private String state;

    public Paper(){}

    public Paper(String title, String summary, List<Keyword> keywords, List<PaperFile> paper_files, List<Source> sources, User author, LocalDate upload_date, List<PaperAssignment> paper_assignments, String paper_field, String state) {
        this.title = title;
        this.summary = summary;
        this.keywords = keywords;
        this.paper_files = paper_files;
        this.sources = sources;
        this.author = author;
        this.upload_date = upload_date;
        this.paper_assignments = paper_assignments;
        this.paper_field = paper_field;
        this.state = state;
    }

    public void addPaperFileToPaper(PaperFile paperFile){
        if(paper_files==null){
            paper_files=new ArrayList<>();
        }
        paper_files.add(paperFile);
    }

    public void changeKeywords(List<String> newKeywords){
        List<Keyword> keywordlist=new ArrayList<>();
        for(int i=0; i<newKeywords.size(); i++){
            Keyword keyword=new Keyword();
            keyword.setKeyword(newKeywords.get(i));
            keyword.setPaper(this);
            keywordlist.add(keyword);
        }
        this.setKeywords(keywordlist);
    }

    public void changeSources(List<String> newSources){
        List<Source> sourceList=new ArrayList<>();
        for(int i=0; i<newSources.size(); i++){
            Source source=new Source();
            source.setSource(newSources.get(i));
            source.setPaper(this);
            sourceList.add(source);
        }
        this.setSources(sourceList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public List<PaperFile> getPaper_files() {
        return paper_files;
    }

    public void setPaper_files(List<PaperFile> paper_files) {
        this.paper_files = paper_files;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDate getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(LocalDate upload_date) {
        this.upload_date = upload_date;
    }

    public List<PaperAssignment> getPaper_assignments() {
        return paper_assignments;
    }

    public void setPaper_assignments(List<PaperAssignment> paper_assignments) {
        this.paper_assignments = paper_assignments;
    }

    public String getPaper_field() {
        return paper_field;
    }

    public void setPaper_field(String paper_field) {
        this.paper_field = paper_field;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Paper(int id, String title, String summary, List<Keyword> keywords, List<PaperFile> paper_files, List<Source> sources, User author, LocalDate upload_date, List<PaperAssignment> paper_assignments, String paper_field, String state) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.keywords = keywords;
        this.paper_files = paper_files;
        this.sources = sources;
        this.author = author;
        this.upload_date = upload_date;
        this.paper_assignments = paper_assignments;
        this.paper_field = paper_field;
        this.state = state;
    }
}

