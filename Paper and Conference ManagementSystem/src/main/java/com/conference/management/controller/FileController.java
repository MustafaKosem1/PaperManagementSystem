package com.conference.management.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class FileController {
    private final Path fileFolder;

    public FileController(@Value("${myFilePath}") String myFilePath) {
        this.fileFolder = Paths.get(myFilePath);
    }

    @GetMapping("{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) throws IOException {
        Path path = fileFolder.resolve(fileName);
        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + fileName) // Bu satır PDF dosyasının indirilebilir olduğunu belirtir
                .header("Content-Type", "application/pdf") // Bu satır PDF dosyasının türünü belirtir
                .body(resource);
    }
}
