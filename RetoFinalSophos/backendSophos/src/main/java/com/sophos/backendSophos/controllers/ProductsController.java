package com.sophos.backendSophos.controllers;


import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.services.Products.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping
    private ResponseEntity<List<Products>> listProducts(){
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @GetMapping("/{id}")
    private ResponseEntity<List<Products>> listProductsByClient(@PathVariable("id") Long id){

        return ResponseEntity.ok(productsService.getProductsByClientId(id));
    }


}
