package com.testbank.bank.repository;

import com.testbank.bank.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccount, String> {
    BankAccount findByAccountNumber(String accountNumber);
}
