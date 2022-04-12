package com.example.javawebdevprojekt;

import com.example.javawebdevprojekt.entities.Konsult;
import com.example.javawebdevprojekt.entities.Organisation;
import com.example.javawebdevprojekt.entities.TimRapport;
import com.example.javawebdevprojekt.repositories.KonsultRepo;
import com.example.javawebdevprojekt.repositories.OrganisationRepo;
import com.example.javawebdevprojekt.repositories.TimRapportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JavaWebDevProjektApplication implements CommandLineRunner {

    @Autowired
    TimRapportRepo timRapportRepo;

    @Autowired
    KonsultRepo konsultRepo;

    @Autowired
    OrganisationRepo organisationRepo;

    public static void main(String[] args) {
        SpringApplication.run(JavaWebDevProjektApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Konsult arne = new Konsult("hej", "hopp");
        arne.setFirstName("Arne");
        arne.setLastName("Arnesson");
        konsultRepo.save(arne);



        Organisation org1 = new Organisation("Pulsen");
        Organisation org2 = new Organisation("Pagen");
        Organisation org3 = new Organisation("Ajax");
        Organisation org4 = new Organisation("Nintendo");
        Organisation org5 = new Organisation("github");

        TimRapport rap1 = new TimRapport(org1, 8, arne);
        TimRapport rap2 = new TimRapport(org2, 8, arne);
        TimRapport rap3 = new TimRapport(org3, 8, arne);
        TimRapport rap4 = new TimRapport(org4, 8, arne);

        organisationRepo.saveAll(List.of(org1, org2, org3, org4, org5));

        timRapportRepo.saveAll(List.of(rap1, rap2, rap3, rap4));
    }
}
