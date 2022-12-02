package com.sophos.backendSophos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Products {

    // Table Columns

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "accountType")
    private String accountType;

    @Column(name = "accountNumber")
    private Integer accountNumber;

    @Column(name = "productState")
    private String firstName;

    @Column(name = "accountBalance")
    private Float lastName;

    @Column(name= "availableBalance")
    private Float availableBalance;

    @Column(name= "exemptGMT")
    private Boolean exemptGMT;

    @Column(name= "createdAt")
    private Date createdAt;

    @Column(name= "createdBy")
    private String createdBy;

    @Column(name= "modifiedOn")
    private Date modifiedOn;

    @Column(name= "modifiedBy")
    private String modifiedBy;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Clients clients;

    @JsonManagedReference
    @OneToMany(mappedBy = "products",cascade = CascadeType.ALL)
    private List<Transactions> transactionsList;

    //Constuctors

    public Products() {
    }

    public Products(String accountType, Integer accountNumber, String firstName, Float lastName, Float availableBalance, Boolean exemptGMT, Date createdAt, String createdBy, Date modifiedOn, String modifiedBy, Clients clients, List<Transactions> transactionsList) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.availableBalance = availableBalance;
        this.exemptGMT = exemptGMT;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
        this.clients = clients;
        this.transactionsList = transactionsList;
    }

    //Getters y Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Float getLastName() {
        return lastName;
    }

    public void setLastName(Float lastName) {
        this.lastName = lastName;
    }

    public Float getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Float availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Boolean getExemptGMT() {
        return exemptGMT;
    }

    public void setExemptGMT(Boolean exemptGMT) {
        this.exemptGMT = exemptGMT;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }
}
