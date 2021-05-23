package com.testbank.bank.dto;

import com.testbank.bank.entity.AccountType;
import com.testbank.bank.entity.BankAccount;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankAccountDTO {
    private String bankAccountId;
    private String bankAccountNumber;
    private String bankName;
    private String user;
    public BankAccountDTO(BankAccount bankAccount) {
        this.bankAccountId = bankAccount.getBankAccountId();
        this.bankAccountNumber = bankAccount.getAccountNumber();
        this.bankName = bankAccount.getBankName();
        this.user = bankAccount.getUser().getName();
    }
}
