package com.example.javawebdevprojekt;

import com.example.javawebdevprojekt.entities.Konsult;
import com.example.javawebdevprojekt.entities.TimRapport;
import com.example.javawebdevprojekt.repositories.KonsultRepo;
import com.example.javawebdevprojekt.repositories.TimRapportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaWebDevProjektApplication implements CommandLineRunner {

    @Autowired
    TimRapportRepo timRapportRepo;

    @Autowired
    KonsultRepo konsultRepo;

    public static void main(String[] args) {
        SpringApplication.run(JavaWebDevProjektApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Konsult arne = new Konsult("hej", "hopp");
        konsultRepo.save(arne);

        TimRapport rap1 = new TimRapport("Pulsen", 8, arne);
        TimRapport rap2 = new TimRapport("Pagen", 8, arne);
        TimRapport rap3 = new TimRapport("Ajax", 8, arne);
    }
}
