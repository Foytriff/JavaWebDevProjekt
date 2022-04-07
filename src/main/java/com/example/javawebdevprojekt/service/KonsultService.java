package com.example.javawebdevprojekt.service;

import com.example.javawebdevprojekt.entities.Konsult;
import com.example.javawebdevprojekt.repositories.KonsultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KonsultService{
    @Autowired
    KonsultRepo konsultRepo;
    public void createKonsult(Konsult konsult){
    }
}
