package com.sophos.backendSophos.services.Transactions.Impl;

import com.sophos.backendSophos.dto.Transactions.TransactionsCreateDto;
import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.models.Transactions;
import com.sophos.backendSophos.repository.ProductsRepository;
import com.sophos.backendSophos.repository.TransactionsRepository;
import com.sophos.backendSophos.services.Transactions.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    ProductsRepository productsRepository;

    public List<Transactions> getAllTransactions(){
        return transactionsRepository.findAll();
    }
    public List<Transactions> getTransactionsByProductId(Long id){
        return transactionsRepository.findByProductsId(id);
    }

    public Transactions createTransactionsByProductId(TransactionsCreateDto transactionCreate, Long id){
        Products product = productsRepository.findById(id).get();
        Products productToTransfer = productsRepository.findById(transactionCreate.getDestinationAccountId()).get();
        Transactions newTransaction = new Transactions();
        String transactionType = transactionCreate.getTransactionType();

        setOperationType(newTransaction, transactionType, product,transactionCreate, productToTransfer);
        product.setAvailableBalance(product.getAccountBalance()); // Tener en cuenta si se aplica GMF
        productsRepository.save(product);
        return transactionsRepository.save(createNewTransaction(newTransaction, transactionCreate, product));
    }


    private void setOperationType(
            Transactions newTransaction,
            String transactionType,
            Products product,
            TransactionsCreateDto transactionCreate,
            Products productToTransfer){

        if (transactionType.equals("deposit")){
            product.setAccountBalance(product.getAccountBalance().add(transactionCreate.getValue()));
            newTransaction.setOperationType("Saving"); //Debito es traducido al ingles como Saving

        } else if (transactionType.equals("withdrawal")) {
            product.setAccountBalance(product.getAccountBalance().subtract(transactionCreate.getValue()));
            newTransaction.setOperationType("Credit");

        } else if (transactionType.equals("transfer")) {
            product.setAccountBalance(product.getAccountBalance().subtract(transactionCreate.getValue()));
            newTransaction.setOperationType("Credit");
            productToTransfer.setAccountBalance(productToTransfer.getAccountBalance().add(transactionCreate.getValue()));
            productToTransfer.setAvailableBalance(productToTransfer.getAccountBalance()); // Tener en cuenta si se aplica GMF
            productsRepository.save(productToTransfer);
        }
    }

    private Transactions createNewTransaction(Transactions newTransaction, TransactionsCreateDto transactionCreate, Products product){
        newTransaction.setDescription("Transaction type" + " " +transactionCreate.getTransactionType() + " " + "Account" + " " +transactionCreate.getDestinationAccountId());
        newTransaction.setTransactionType(transactionCreate.getTransactionType());
        newTransaction.setValue(transactionCreate.getValue());
        newTransaction.setDestinationAccountId(transactionCreate.getDestinationAccountId());
        newTransaction.setCreatedBy("Admin");
        newTransaction.setCreatedAt(LocalDate.now());
        newTransaction.setModifiedBy("Admin");
        newTransaction.setModifiedOn(LocalDate.now());
        newTransaction.setProducts(product);
        return newTransaction;
    }
}