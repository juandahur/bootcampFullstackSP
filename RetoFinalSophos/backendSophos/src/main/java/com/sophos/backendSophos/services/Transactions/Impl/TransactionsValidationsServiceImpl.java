package com.sophos.backendSophos.services.Transactions.Impl;

import com.sophos.backendSophos.dto.Transactions.TransactionsCreateDto;
import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.services.Products.ProductsService;
import com.sophos.backendSophos.services.Transactions.TransactionsValidationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionsValidationsServiceImpl implements TransactionsValidationsService {

    @Autowired
    ProductsService productsService;

    public boolean validateTransactionCreate(Long id, TransactionsCreateDto transactionCreate) {

        Products product = productsService.getProductById(id).get();

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

    public boolean validateProductState(Long id){

        Products product = productsService.getProductById(id).get();
        if(product.getProductState().equals("Cancelled")){
            return true;
        }return false;
    }

    public boolean validateInactiveTransactions(Long id,TransactionsCreateDto transactionCreate){
        Products product = productsService.getProductById(id).get();
        if(product.getProductState().equals("Inactive") && transactionCreate.getTransactionType().equals("deposit")){
            return true;
        }return false;
    }
}
