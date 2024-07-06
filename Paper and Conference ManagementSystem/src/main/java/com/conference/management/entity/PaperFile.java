package com.conference.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "paper_file")
public class PaperFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "file_location")
    private String file_location;

    @JsonIgnoreProperties("paper_files")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paper_id")
    private Paper file_owner_paper;

    public PaperFile(){}

    public PaperFile(String file_location, Paper file_owner_paper) {
        this.file_location = file_location;
        this.file_owner_paper = file_owner_paper;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile_location() {
        return file_location;
    }

    public void setFile_location(String file_location) {
        this.file_location = file_location;
    }

    public Paper getFile_owner_paper() {
        return file_owner_paper;
    }

    public void setFile_owner_paper(Paper file_owner_paper) {
        this.file_owner_paper = file_owner_paper;
    }
}
