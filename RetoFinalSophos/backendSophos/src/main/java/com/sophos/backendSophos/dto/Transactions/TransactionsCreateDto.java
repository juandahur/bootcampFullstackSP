package com.sophos.backendSophos.dto.Transactions;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionsCreateDto {

    private String transactionType;

    private BigDecimal value;

    private Long destinationAccountId;

    public String getTransactionType() {
        return transactionType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Long getDestinationAccountId() {
        return destinationAccountId;
    }
}
