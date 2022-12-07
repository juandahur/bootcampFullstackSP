package com.sophos.backendSophos.dto.Products;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductsCreateDto {

    private String accountType;

    public String getAccountType() {
        return accountType;
    }
}
