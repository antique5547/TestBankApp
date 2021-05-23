package com.testbank.bank.utils;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Configuration
public class HibernateUtils {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Bean(name = "sessionFactory")
//    public SessionFactory getSessionFactory(){
//        return entityManager.unwrap(SessionFactory.class);
//    }
}
