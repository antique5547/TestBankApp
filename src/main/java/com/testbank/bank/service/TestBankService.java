package com.testbank.bank.service;

import com.testbank.bank.dto.BankAccountDTO;
import com.testbank.bank.dto.RequestResource;
import com.testbank.bank.dto.TransactionDTO;
import com.testbank.bank.dto.TxnHistoryDTO;

import java.util.List;

public interface TestBankService {

    List<TxnHistoryDTO> findAllTxnHistory(RequestResource requestResource);

    BankAccountDTO findByAccountNumber(String accountNumber);

    TransactionDTO postTransaction(TransactionDTO transactionDTO);
}
