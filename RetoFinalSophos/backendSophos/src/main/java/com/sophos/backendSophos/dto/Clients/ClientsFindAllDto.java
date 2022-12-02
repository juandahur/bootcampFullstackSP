package com.sophos.backendSophos.dto.Clients;

import jakarta.persistence.Column;

import java.time.LocalDate;


public class ClientsFindAllDto {

    private Long id;

    private String idDocument;

    private int idNumber;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

    private LocalDate createdAt;

    private String createdBy;

    private LocalDate modifiedOn;

    private String modifiedBy;

    public Long getId() {
        return id;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDate getModifiedOn() {
        return modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
}
