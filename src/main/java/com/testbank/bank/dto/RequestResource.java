package com.testbank.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestResource {
    String txnId;
    String paidTo;
    String debitedFrom;
    String debitedAmount;
    String creditedFrom;
    String creditedAmount;
    TxnType TxnType;
    TxnStatus TxnStatus;
    int count;
}
