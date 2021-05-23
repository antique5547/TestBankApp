package com.testbank.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private String userId = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String mobile;
    private String panNumber;
    private String aadharNumber;
    @OneToOne(mappedBy = "user")
    private BankAccount bankAccount;

    public User(String name, String email, String mobile, String panNumber, String aadharNumber) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.panNumber = panNumber;
        this.aadharNumber = aadharNumber;
    }
}
