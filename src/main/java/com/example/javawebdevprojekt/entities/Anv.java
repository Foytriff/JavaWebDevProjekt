package com.example.javawebdevprojekt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Anv {
    String username;
    String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    public Anv(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Anv(){

    }

    public int getId(){
        return this.Id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}
