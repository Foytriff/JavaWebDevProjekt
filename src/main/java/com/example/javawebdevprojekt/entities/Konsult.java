package com.example.javawebdevprojekt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Konsult extends Anv{
    private String name;
    private String tel;
    private String email;
    private String personnr;

    public Konsult(String username, String password){
        super(username, password);
    }

    public Konsult(){

    }
}
