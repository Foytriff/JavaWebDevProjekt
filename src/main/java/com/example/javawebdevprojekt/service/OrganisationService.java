package com.example.javawebdevprojekt.service;

import com.example.javawebdevprojekt.entities.Organisation;
import com.example.javawebdevprojekt.repositories.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationService {
    @Autowired
    OrganisationRepo organisationRepo;

    public List<Organisation> findAll(){
        return organisationRepo.findAll();
    }

    public Organisation save(Organisation o){
        return organisationRepo.save(o);
    }
}
