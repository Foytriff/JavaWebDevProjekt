package com.example.javawebdevprojekt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Konsult extends Anv{
    private String firstName;
    private String lastName;
    private String tel;
    private String email;
    private String personnr;

    public Konsult(String username, String password){
        super(username, password);
        this.firstName = "";
        this.lastName = "";
        this.tel = "";
        this.email = "";
        this.personnr = "";
    }

    public Konsult(){

    }
}
