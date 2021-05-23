package com.testbank.bank.repository;

import com.testbank.bank.dto.RequestResource;
import com.testbank.bank.entity.TxnHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomTxnHistoryRepo {
    List<TxnHistory> findByTxnHistoryWithCriteria(RequestResource requestResource);
}
