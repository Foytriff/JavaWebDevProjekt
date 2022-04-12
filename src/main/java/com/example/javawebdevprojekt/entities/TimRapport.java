package com.example.javawebdevprojekt.entities;

import com.example.javawebdevprojekt.service.OrganisationService;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class TimRapport {
    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organisation organisation; //byt till enum
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String datum;
    private double antalTimmar;
    @ManyToOne
    @JoinColumn(name = "konsult_id")
    private Konsult konsult;

    public TimRapport(Organisation organisation, double antalTimmar, Konsult konsult) {
        this.organisation = organisation;
        this.antalTimmar = antalTimmar;
        this.konsult = konsult; // byt ut till inloggad.

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.datum = dtf.format(now);
    }

    public TimRapport(){

    }

    public String getOrganisation() {
        return organisation.getName();
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getAntalTimmar() {
        return antalTimmar;
    }

    public void setAntalTimmar(double antalTimmar) {
        this.antalTimmar = antalTimmar;
    }

    public Konsult getKonsult() {
        return konsult;
    }

    public void setKonsult(Konsult konsult) {
        this.konsult = konsult;
    }
}
