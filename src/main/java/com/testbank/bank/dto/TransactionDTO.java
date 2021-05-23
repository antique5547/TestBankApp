package com.testbank.bank.dto;

import com.testbank.bank.entity.TxnHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    String txnId;
    String fromAccount;
    String toAccount;
    Double txnAmount;

    public TransactionDTO(TxnHistory txnHistory) {
        this.txnId = txnHistory.getTxnId();
        this.fromAccount = txnHistory.getDebitedFrom().getAccountNumber();
        this.toAccount = txnHistory.getCreditedTo().getAccountNumber();
        this.txnAmount = txnHistory.getTxnAmount();
    }
}
