package com.sophos.backendSophos.services.Transactions;

import com.sophos.backendSophos.dto.Transactions.TransactionsCreateDto;
import com.sophos.backendSophos.models.Transactions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionsService {

    List <Transactions> getAllTransactions();
    List<Transactions> getTransactionsByProductId(Long id);

    Transactions createTransactionsByProductId(TransactionsCreateDto transactionCreate,Long id);



}
