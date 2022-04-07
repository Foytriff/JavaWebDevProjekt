package com.example.javawebdevprojekt.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class TimRapport {
    private String organisation; //byt till enum
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String datum;
    private double antalTimmar;
    @ManyToOne
    @JoinColumn(name = "konsult_id")
    private Konsult konsult;

    public TimRapport(String organisation, double antalTimmar, Konsult konsult) {
        this.organisation = organisation;
        this.antalTimmar = antalTimmar;
        this.konsult = konsult; // byt ut till inloggad.

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.datum = dtf.format(now);
    }

    public TimRapport(){

    }
}
