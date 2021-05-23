package com.testbank.bank.repository;

import com.testbank.bank.dto.RequestResource;
import com.testbank.bank.entity.TxnHistory;
import com.testbank.bank.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomTxnHistoryRepoImpl implements CustomTxnHistoryRepo{
    private static final int DEFAULT_COUNT = 10;
    //    @Autowired
//    HibernateUtils hibernateUtils;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TxnHistory> findByTxnHistoryWithCriteria(RequestResource requestResource) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TxnHistory> criteriaQuery = criteriaBuilder.createQuery(TxnHistory.class);
        Root<TxnHistory> txnHistoryRoot = criteriaQuery.from(TxnHistory.class);
        List<Predicate> predicates = new ArrayList<>();
        if(requestResource == null)
            return entityManager.createQuery(criteriaQuery).getResultList();
        if(requestResource.getTxnId() != null)
            predicates.add(criteriaBuilder.equal(txnHistoryRoot.get("txnId"), requestResource.getTxnId()));
        if(requestResource.getPaidTo() != null)
            predicates.add(criteriaBuilder.equal(txnHistoryRoot.get("paidTo"), requestResource.getPaidTo()));
        if(requestResource.getTxnType() != null)
            predicates.add(criteriaBuilder.equal(txnHistoryRoot.get("txnType"), requestResource.getTxnType()));
        if(requestResource.getTxnStatus() != null)
            predicates.add(criteriaBuilder.equal(txnHistoryRoot.get("txnStatus"), requestResource.getTxnStatus()));
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(criteriaQuery).setMaxResults(requestResource.getCount() != 0 ? requestResource.getCount() : DEFAULT_COUNT ).getResultList();
    }
}
