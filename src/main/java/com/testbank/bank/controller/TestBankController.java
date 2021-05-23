package com.testbank.bank.controller;

import com.testbank.bank.dto.BankAccountDTO;
import com.testbank.bank.dto.RequestResource;
import com.testbank.bank.dto.TransactionDTO;
import com.testbank.bank.dto.TxnHistoryDTO;
import com.testbank.bank.service.TestBankService;
import com.testbank.bank.service.TestBankServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController("/testbank")
@Slf4j
public class TestBankController {

    @Autowired
    TestBankService testBankService;

    @GetMapping("/txn/history")
    public ResponseEntity<List<TxnHistoryDTO>> getTxnHistory(@ModelAttribute RequestResource requestResource){
        log.info("requestResource : {}",requestResource);
        List<TxnHistoryDTO> allTxnHistory = testBankService.findAllTxnHistory(requestResource);
        return ResponseEntity.ok(allTxnHistory);
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<BankAccountDTO> getAccount(@PathVariable("accountNumber") String accountNumber){
        log.info("accountNumber : {}",accountNumber);
        BankAccountDTO byAccountNumber = testBankService.findByAccountNumber(accountNumber);
        return ResponseEntity.ok(byAccountNumber);
    }

    @PostMapping("/payment")
    public ResponseEntity<TransactionDTO> postTransaction(@RequestBody TransactionDTO transactionDTO){
        log.info("transactionDTO : {}",transactionDTO);
        TransactionDTO transactionDTO1 = testBankService.postTransaction(transactionDTO);
        return ResponseEntity.accepted().body(transactionDTO1);
    }
}
