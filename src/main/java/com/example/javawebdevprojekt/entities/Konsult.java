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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonnr() {
        return personnr;
    }

    public void setPersonnr(String personnr) {
        this.personnr = personnr;
    }
}
