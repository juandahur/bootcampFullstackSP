package com.sophos.backendSophos.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "clients")
public class Clients {

    // Table Columns

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "idDocument")
    private String idDocument;

    @Column(name = "idNumber")
    private String idNumber;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name= "email")
    private String email;

    @Column(name= "birthDate")
    private LocalDate birthDate;

    @Column(name= "createdAt")
    private LocalDate createdAt;

    @Column(name= "createdBy")
    private String createdBy;

    @Column(name= "modifiedOn")
    private LocalDate modifiedOn;

    @Column(name= "modifiedBy")
    private String modifiedBy;

    @JsonManagedReference
    @OneToMany(mappedBy = "clients",cascade = CascadeType.ALL)
    private List<Products> productsList;

    //Constructors

    //Empty constructor
    public Clients(){
   }

    //

    public Clients(String idDocument, String idNumber, String firstName, String lastName, String email, LocalDate birthDate, LocalDate createdAt, String createdBy, LocalDate modifiedOn, String modifiedBy, List<Products> productsList) {
        this.idDocument = idDocument;
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
        this.productsList = productsList;
    }


    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDate modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
