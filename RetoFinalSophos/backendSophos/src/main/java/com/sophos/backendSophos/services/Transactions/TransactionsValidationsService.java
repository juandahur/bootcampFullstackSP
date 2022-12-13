package com.sophos.backendSophos.services.Transactions;

import com.sophos.backendSophos.dto.Transactions.TransactionsCreateDto;
import com.sophos.backendSophos.models.Products;

public interface TransactionsValidationsService {

   boolean validateTransactionCreate(Long id, TransactionsCreateDto transactionCreate);

   boolean validateProductState(Long id);

   boolean validateInactiveTransactions(Long id,TransactionsCreateDto transactionCreate);

}
