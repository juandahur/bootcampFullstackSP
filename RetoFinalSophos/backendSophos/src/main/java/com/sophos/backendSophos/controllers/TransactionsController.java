package com.sophos.backendSophos.controllers;

import com.sophos.backendSophos.dto.Transactions.TransactionsCreateDto;
import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.models.Transactions;
import com.sophos.backendSophos.services.Products.ProductsService;
import com.sophos.backendSophos.services.Transactions.TransactionsService;
import com.sophos.backendSophos.services.Transactions.TransactionsValidationsService;
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

    @Autowired
    TransactionsValidationsService transactionsValidationsService;

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
            if(transactionsValidationsService.validateProductState(id)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Cancelled account ");
            }
            if (transactionsValidationsService.validateInactiveTransactions(id,transactionCreate)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Inactive accounts can't deposit");
            }

            if(transactionsValidationsService.validateTransactionCreate(id,transactionCreate)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Non-sufficient funds ");

            }
            Transactions temporal = transactionsService.createTransactionsByProductId(transactionCreate, id);
            return ResponseEntity.created(new URI("/transactions" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }






}
