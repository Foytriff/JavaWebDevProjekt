package com.example.javawebdevprojekt.entities;

import javax.annotation.Nullable;
import javax.persistence.*;

@Entity
public abstract class Anv {
    @Nullable()
    String username;
    @Column
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
