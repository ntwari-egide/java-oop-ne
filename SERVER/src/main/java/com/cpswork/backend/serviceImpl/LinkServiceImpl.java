package com.cpswork.backend.serviceImpl;

import com.cpswork.backend.models.Link;
import com.cpswork.backend.models.Website;
import com.cpswork.backend.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private WebsiteServiceImpl websiteService;

    // save list of links to database
    public void saveLinks(List<Link> links) {
        for (Link link : links) {
            linkRepository.save(link);
        }
    }

    // get all
    public List<Link> getAll() {
        return linkRepository.findAll();
    }

    //get link by website
    public List<Link> getWebsite(String websiteName) {
        System.out.println("reached here ...................");

        Website website = websiteService.findByWebsiteName(websiteName);


        return linkRepository.findByWebsite(website);
    }
}
