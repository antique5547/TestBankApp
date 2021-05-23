package com.testbank.bank.repository;

import com.testbank.bank.entity.TxnHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxnHistoryRepo extends JpaRepository<TxnHistory, String>, CustomTxnHistoryRepo {
}
