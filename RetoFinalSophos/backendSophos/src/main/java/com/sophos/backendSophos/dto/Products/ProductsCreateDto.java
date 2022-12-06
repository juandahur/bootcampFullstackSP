package com.sophos.backendSophos.dto.Products;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductsCreateDto {

    private Long id;

    private String accountType;

    public Long getId() {
        return id;
    }

    public String getAccountType() {
        return accountType;
    }
}
