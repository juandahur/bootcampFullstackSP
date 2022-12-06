package com.sophos.backendSophos.dto.Clients;

import java.time.LocalDate;

public class ClientsUpdateDto {

    private Long id;

    private String idDocument;

    private String idNumber;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

    private LocalDate modifiedOn;

    private String modifiedBy;

    public Long getId() {
        return id;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public String getIdNumber() {
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

    public LocalDate getModifiedOn() {
        return modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

}
