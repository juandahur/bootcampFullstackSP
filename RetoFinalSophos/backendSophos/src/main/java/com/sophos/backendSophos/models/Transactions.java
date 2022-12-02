package com.sophos.backendSophos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "transactionType")
    private String transactionType;

    @Column(name = "description")
    private String description;

    @Column(name = "transactionState")
    private String transactionState;

    @Column(name= "createdAt")
    private LocalDate createdAt;

    @Column(name= "createdBy")
    private String createdBy;

    @Column(name= "modifiedOn")
    private LocalDate modifiedOn;

    @Column(name= "modifiedBy")
    private String modifiedBy;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products products;


    //Constructors

    public Transactions(){

    }

    public Transactions(String transactionType, String description, String transactionState, LocalDate createdAt, String createdBy, LocalDate modifiedOn, String modifiedBy, Products products) {
        this.transactionType = transactionType;
        this.description = description;
        this.transactionState = transactionState;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
        this.products = products;
    }


    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(String transactionState) {
        this.transactionState = transactionState;
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

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
