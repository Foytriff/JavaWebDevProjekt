package com.example.javawebdevprojekt.service;

import com.example.javawebdevprojekt.entities.TimRapport;
import com.example.javawebdevprojekt.repositories.TimRapportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimRapportService {
    @Autowired
    TimRapportRepo timRapportRepo;

    public List<TimRapport> findAll(){
        return timRapportRepo.findAll();
    }

    public List<TimRapport> findByKonsultId(int KId){
        return timRapportRepo.findAll().stream()
                .filter(tr -> tr.getKonsult().getId() == KId)
                .toList();
    }

    public TimRapport saveTR(TimRapport timRapport){
        return timRapportRepo.save(timRapport);
    }
}
