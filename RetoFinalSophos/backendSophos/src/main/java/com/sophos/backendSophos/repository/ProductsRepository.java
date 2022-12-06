package com.sophos.backendSophos.repository;

import com.sophos.backendSophos.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    public List<Products>  findByClientsId(Long id);



}
