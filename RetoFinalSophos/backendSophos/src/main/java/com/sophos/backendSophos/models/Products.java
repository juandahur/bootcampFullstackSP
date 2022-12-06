package com.sophos.backendSophos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    private String accountNumber;

    @Column(name = "productState")
    private String productState;

    @Column(name = "accountBalance")
    private BigDecimal accountBalance;

    @Column(name= "availableBalance")
    private BigDecimal availableBalance;

    @Column(name= "exemptGMT")
    private Boolean exemptGMT;

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
    @JoinColumn(name = "clients_id")
    private Clients clients;

    @JsonManagedReference
    @OneToMany(mappedBy = "products",cascade = CascadeType.ALL)
    private List<Transactions> transactionsList;

    //Constuctors

    public Products() {
    }

    public Products(Long id, String accountType, String accountNumber, String productState, BigDecimal accountBalance, BigDecimal availableBalance, Boolean exemptGMT, LocalDate createdAt, String createdBy, LocalDate modifiedOn, String modifiedBy, Clients clients, List<Transactions> transactionsList) {
        this.id = id;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.productState = productState;
        this.accountBalance = accountBalance;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Boolean getExemptGMT() {
        return exemptGMT;
    }

    public void setExemptGMT(Boolean exemptGMT) {
        this.exemptGMT = exemptGMT;
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
