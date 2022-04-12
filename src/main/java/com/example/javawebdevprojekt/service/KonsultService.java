package com.example.javawebdevprojekt.service;

import com.example.javawebdevprojekt.entities.Konsult;
import com.example.javawebdevprojekt.repositories.KonsultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KonsultService{
    @Autowired
    KonsultRepo konsultRepo;

    public List<Konsult> findAll(){
        return konsultRepo.findAll();
    }

    public Konsult findKonsultById(int id){
        return konsultRepo.findAll().stream()
                .filter(k -> k.getId() == id)
                .findFirst().orElseThrow();
    }
}
