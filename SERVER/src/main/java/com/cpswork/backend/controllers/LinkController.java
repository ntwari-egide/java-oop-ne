package com.cpswork.backend.controllers;

import com.cpswork.backend.dtos.UrlRequest;
import com.cpswork.backend.models.Link;
import com.cpswork.backend.models.Website;
import com.cpswork.backend.serviceImpl.LinkServiceImpl;
import com.cpswork.backend.serviceImpl.WebsiteExtractorServiceImpl;
import com.cpswork.backend.serviceImpl.WebsiteServiceImpl;
import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/websites-links")
public class LinkController {

    @Autowired
    private LinkServiceImpl linkService;

    @Autowired
    private WebsiteExtractorServiceImpl websiteExtractorService;

    @GetMapping("/get-all")
    public List<Link> getAll() {
        return linkService.getAll();
    }
    @GetMapping("/{id}")
    public Website findById(@PathVariable UUID id) {
        return null;
    }

    @PostMapping("/save-links")
    public ResponseEntity<?> create(@RequestBody UrlRequest urlRequest) {


        return ResponseEntity.created(null).build();
    }



}
