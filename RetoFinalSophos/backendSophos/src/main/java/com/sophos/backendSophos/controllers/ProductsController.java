package com.sophos.backendSophos.controllers;

import com.sophos.backendSophos.dto.Products.ProductsCreateDto;
import com.sophos.backendSophos.dto.Products.ProductsUpdateStateDto;
import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.services.Products.ProductsService;
import com.sophos.backendSophos.services.Products.ProductsValidationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;


    @Autowired
    ProductsValidationsService productsValidationService;

    @GetMapping
    private ResponseEntity<List<Products>> listProducts(){
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @GetMapping("/{id}")
    private ResponseEntity<List<Products>> listProductsByClient(@PathVariable("id") Long id){

        return ResponseEntity.ok(productsService.getProductsByClientId(id));
    }

    @PostMapping("/{id}")
    private ResponseEntity saveProductByClientId(@RequestBody ProductsCreateDto productCreate,@PathVariable("id") Long id) {

        try {
            Products temporal = productsService.createProductByClientId(productCreate,id);
            return ResponseEntity.created(new URI("/products" + temporal.getId())).body(temporal);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping("/state/{id}")
    private ResponseEntity updateState(@RequestBody ProductsUpdateStateDto productState, @PathVariable Long id) {


        try {
            if(productsValidationService.validateProductState(productState)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please provide a different Product State");
            }

            if(productsValidationService.validateProductStateUpdate(productState,id)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check accounts balance");
            }
            Products temporal = productsService.updateProductState(productState, id);
            return ResponseEntity.created(new URI("/products" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("State update error");
        }
    }




}
