package com.testbank.bank.service;

import com.testbank.bank.dto.*;
import com.testbank.bank.entity.BankAccount;
import com.testbank.bank.entity.TxnHistory;
import com.testbank.bank.repository.BankAccountRepo;
import com.testbank.bank.repository.TxnHistoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TestBankServiceImpl implements TestBankService {

    @Autowired
    TxnHistoryRepo txnHistoryRepo;

    @Autowired
    BankAccountRepo bankAccountRepo;

    @Override
    public List<TxnHistoryDTO> findAllTxnHistory(RequestResource requestResource) {
        List<TxnHistory> txnHistoryList = txnHistoryRepo.findByTxnHistoryWithCriteria(requestResource);

        return txnHistoryList.stream().map(TxnHistoryDTO::new).collect(Collectors.toList());
    }

    public BankAccountDTO findByAccountNumber(String accountNumber) {
        BankAccount bankAccount = bankAccountRepo.findByAccountNumber(accountNumber);
        Assert.notNull(bankAccount, "Account ID not found");
        return new BankAccountDTO(bankAccount);
    }

    @Override
    @Transactional
    public TransactionDTO postTransaction(TransactionDTO transactionDTO) {
        TxnHistory history = null;
        TxnHistory txnHistory = null;
        BankAccount fromAccount = bankAccountRepo.findByAccountNumber(transactionDTO.getFromAccount());
        Assert.notNull(fromAccount, "fromAccount not valid");
        BankAccount toAccount = bankAccountRepo.findByAccountNumber(transactionDTO.getToAccount());
        Assert.notNull(toAccount, "toAccount not valid");
        log.info("balance in debited account {} : {}", fromAccount.getAccountNumber(), fromAccount.getBankBalance());
        log.info("balance in credited account {} : {}", toAccount.getAccountNumber(), toAccount.getBankBalance());
        try {
            txnHistory = new TxnHistory(fromAccount, toAccount, transactionDTO.getTxnAmount(), TxnStatus.SUCCESS);
            Assert.isTrue(fromAccount.getBankBalance() > transactionDTO.getTxnAmount(), "Amount is not sufficient in account : "+ transactionDTO.getFromAccount());
            Double totalBalInDebitAccount = fromAccount.getBankBalance() - transactionDTO.getTxnAmount();
            Double totalBalInCreditAccount = toAccount.getBankBalance() + transactionDTO.getTxnAmount();
            fromAccount.setBankBalance(totalBalInDebitAccount);
            toAccount.setBankBalance(totalBalInCreditAccount);
            history = txnHistoryRepo.save(txnHistory);
        }catch (Exception e){
            txnHistory.setTxnStatus(TxnStatus.FAILED);
            history = txnHistoryRepo.save(txnHistory);
            throw e;
        }

        return new TransactionDTO(history);
    }

    private void auditTxnHistory(BankAccount fromAccount, BankAccount toAccount, TransactionDTO transactionDTO) {

    }
}
