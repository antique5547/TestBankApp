package com.testbank.bank.dto;

import com.testbank.bank.entity.TxnHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TxnHistoryDTO {
    private String txnId = UUID.randomUUID().toString();
    private BankAccountDTO debitedFrom;
    private BankAccountDTO creditedFrom;
    private Double txnAmount;
    private TxnType txnType;
    private TxnStatus txnStatus;

    public TxnHistoryDTO(TxnHistory txnHistory) {
        this.txnId = txnHistory.getTxnId();
        this.debitedFrom = new BankAccountDTO(txnHistory.getDebitedFrom());
        this.txnAmount = txnHistory.getTxnAmount();
        this.creditedFrom = new BankAccountDTO(txnHistory.getCreditedTo());
        this.txnType = txnHistory.getTxnType();
        this.txnStatus = txnHistory.getTxnStatus();
    }
}
