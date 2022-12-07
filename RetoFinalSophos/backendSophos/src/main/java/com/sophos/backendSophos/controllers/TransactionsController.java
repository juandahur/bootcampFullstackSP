package com.sophos.backendSophos.controllers;

import com.sophos.backendSophos.dto.Transactions.TransactionsCreateDto;
import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.models.Transactions;
import com.sophos.backendSophos.services.Products.ProductsService;
import com.sophos.backendSophos.services.Transactions.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionsService transactionsService;

    @Autowired
    ProductsService productsService;

    @GetMapping
    private ResponseEntity<List<Transactions>> listProducts(){
        return ResponseEntity.ok(transactionsService.getAllTransactions());
    }

    @GetMapping("/{id}")
    private ResponseEntity<List<Transactions>> listTransactionsByProduct(@PathVariable("id") Long id){

        return ResponseEntity.ok(transactionsService.getTransactionsByProductId(id));
    }

    @PostMapping("/{id}")
    private ResponseEntity saveTransactionByProductId(@RequestBody TransactionsCreateDto transactionCreate, @PathVariable("id") Long id) {

        try {
            Products product = productsService.getProductById(id).get();

            if(validateProductState(product)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Cancelled account ");
            }
            if (validateInactiveTransactions(product,transactionCreate)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Inactive accounts can't deposit");
            }

            if(validateTransactionCreate(product,transactionCreate)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Non-sufficient funds ");

            }
            Transactions temporal = transactionsService.createTransactionsByProductId(transactionCreate, id);
            return ResponseEntity.created(new URI("/transactions" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    private boolean validateTransactionCreate(Products product, TransactionsCreateDto transactionCreate) {

        int minumumValue =0;
        if (transactionCreate.getTransactionType().equals("withdrawal") || transactionCreate.getTransactionType().equals("transfer")) {

            if(product.getAccountType().equals("SA")){
                minumumValue = 0;
            } else if (product.getAccountType().equals("CA")) {
                minumumValue = -3000000;

            }

            if ((product.getAccountBalance().subtract(transactionCreate.getValue())).compareTo(new BigDecimal(minumumValue)) >= 0 ) {
                return false;
            }
            return true;

        } return false;
    }

    private boolean validateProductState(Products product){

        if(product.getProductState().equals("Cancelled")){
            return true;
        }return false;
    }

    private boolean validateInactiveTransactions(Products product,TransactionsCreateDto transactionCreate){
        if(product.getProductState().equals("Inactive") && transactionCreate.getTransactionType().equals("deposit")){
            return true;
        }return false;
    }




}
