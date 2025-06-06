package com.mkomafamily.property.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tenants")
public class Tenant extends User {
    private String gender;
    private String occupation;
    private String religion;
    private LocalDate dob;

    @Column(name = "additional_notes", columnDefinition = "TEXT", length = 500)
    private String additionalNotes;

    public Tenant() {
    }

    public Tenant(String gender, String occupation, String religion,
            LocalDate dob, String additionalNotes) {
        this.gender = gender;
        this.occupation = occupation;
        this.religion = religion;
        this.dob = dob;
        this.additionalNotes = additionalNotes;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}
