package com.sophos.backendSophos.repository;

import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    public List<Transactions> findByProductsId(Long id);
}
