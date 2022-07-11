package com.cpswork.backend.services;

import com.cpswork.backend.models.Website;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface WebsiteServices {

    public List<Website> findAll();

    public Website findById(UUID id);

    public Website create(Website patientDto);


    public Website delete(UUID id);


}
