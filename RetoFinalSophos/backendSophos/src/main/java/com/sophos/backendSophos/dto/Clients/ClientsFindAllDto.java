package com.sophos.backendSophos.dto.Clients;

import jakarta.persistence.Column;

import java.util.Date;

public class ClientsFindAllDto {

    private Long id;

    private String idDocument;

    private int idNumber;

    private String firstName;

    private String lastName;

    private String email;

    private Date birthDate;

    private Date createdAt;

    private String createdBy;

    private Date modifiedOn;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
}
