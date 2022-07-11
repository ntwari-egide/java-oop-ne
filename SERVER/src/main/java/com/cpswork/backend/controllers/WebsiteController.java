package com.cpswork.backend.controllers;

import com.cpswork.backend.dtos.ApiResponse;
import com.cpswork.backend.dtos.UrlRequest;
import com.cpswork.backend.models.Website;
import com.cpswork.backend.serviceImpl.WebsiteExtractorServiceImpl;
import com.cpswork.backend.serviceImpl.WebsiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/websites")
public class WebsiteController {

    @Autowired
    private WebsiteServiceImpl patientService;

    @Autowired
    private WebsiteExtractorServiceImpl websiteExtractorService;

    @GetMapping("/get-all")
    public List<Website> getAll() {
        return patientService.findAll();
    }
    @GetMapping("/{id}")
    public Website findById(@PathVariable UUID id) {
        return patientService.findById(id);
    }

    @PostMapping("/url")
    public ResponseEntity<?> create(@RequestBody UrlRequest urlRequest) {

        websiteExtractorService.extractWebsite(urlRequest);

        return ResponseEntity.ok( new ApiResponse(
                "Website saved successfully",
                null
        ));
    }

    //SAVE
    @PostMapping("/save")
    public ResponseEntity<?> create(@RequestBody Website website) {
        Website saveWeb = patientService.create(website);
        return ResponseEntity.ok( new ApiResponse(
                 "Website saved successfully",
                saveWeb
                )
        );
    }



}
