package com.sophos.backendSophos.dto.Clients;

import java.util.Date;

public class ClientsCreateDto {

    private String idDocument;

    private int idNumber;

    private String firstName;

    private String lastName;

    private String email;

    private Date birthDate;

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
}
