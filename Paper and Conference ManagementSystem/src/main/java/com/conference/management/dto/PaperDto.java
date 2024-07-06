package com.conference.management.dto;

import com.conference.management.entity.*;

import java.time.LocalDate;
import java.util.List;

public class PaperDto {

    private String title;

    private String summary;

    private List<Keyword> keywords;

    private List<Source> sources;

    private User author;

    private LocalDate upload_date;

    private String paper_field;

    public Paper convertToPaper(Paper paper, int id, List<String> keywords, List<String> sources){
        User author = new User();
        author.setId(id);
        paper.setAuthor(author);
        paper.setUpload_date(LocalDate.now());

        paper.setTitle(this.getTitle());
        paper.setSummary(this.getSummary());
        paper.setPaper_field(this.getPaper_field());

        paper.changeKeywords(keywords);

        paper.changeSources(sources);

        return paper;
    }

    public PaperDto(){}

    public PaperDto(String title, String summary, List<Keyword> keywords, List<Source> sources, User author, LocalDate upload_date, String paper_field) {
        this.title = title;
        this.summary = summary;
        this.keywords = keywords;
        this.sources = sources;
        this.author = author;
        this.upload_date = upload_date;
        this.paper_field = paper_field;
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

    public String getPaper_field() {
        return paper_field;
    }

    public void setPaper_field(String paper_field) {
        this.paper_field = paper_field;
    }
}
