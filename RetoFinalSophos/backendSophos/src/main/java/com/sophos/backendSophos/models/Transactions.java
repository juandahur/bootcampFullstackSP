package com.sophos.backendSophos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
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

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "destinationAccountId")
    private Long destinationAccountId;

    @Column(name = "operationType")
    private String operationType;


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

    public Transactions(String transactionType, String description, BigDecimal value, Long destinationAccountId, String operationType, LocalDate createdAt, String createdBy, LocalDate modifiedOn, String modifiedBy, Products products) {
        this.transactionType = transactionType;
        this.description = description;
        this.value = value;
        this.destinationAccountId = destinationAccountId;
        this.operationType = operationType;
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(Long destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
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
