package com.testbank.bank.entity;

import com.testbank.bank.dto.TxnStatus;
import com.testbank.bank.dto.TxnType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "txn_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TxnHistory {
    @Id
    @Column(name = "id")
    private String txnId = UUID.randomUUID().toString();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debited_bank_account_id", referencedColumnName = "id")
    private BankAccount debitedFrom;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credited_bank_account_id", referencedColumnName = "id")
    private BankAccount creditedTo;
    private Double txnAmount;
    private TxnType txnType;
    private TxnStatus txnStatus;
    private LocalDateTime txnDate = LocalDateTime.now();

    public TxnHistory(BankAccount fromAccount, BankAccount toAccount, Double txnAmount, TxnStatus status) {
        this.debitedFrom = fromAccount;
        this.creditedTo = toAccount;
        this.txnAmount = txnAmount;
        this.txnStatus = status;
    }
}
