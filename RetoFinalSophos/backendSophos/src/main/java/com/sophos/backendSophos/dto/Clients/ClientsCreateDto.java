package com.sophos.backendSophos.dto.Clients;

import java.time.LocalDate;

public class ClientsCreateDto {

    private String idDocument;

    private String idNumber;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

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
}
