package com.enviro.assessment.grad001.mmathusokgalane.repository;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String httpImageLink;
    private String notes;

    public AccountProfile() {
    }
    public AccountProfile(String name, String surname, String httpImageLink, String notes) {
        this.name = name;
        this.surname = surname;
        this.httpImageLink = httpImageLink;
        this.notes = notes;
    }

    public String getHttpImageLink() {
        return httpImageLink;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getNotes(){
        return notes;
    }
}
