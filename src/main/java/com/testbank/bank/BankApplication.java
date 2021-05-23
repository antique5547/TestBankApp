package com.testbank.bank;

import com.testbank.bank.dto.TxnStatus;
import com.testbank.bank.dto.TxnType;
import com.testbank.bank.entity.AccountType;
import com.testbank.bank.entity.BankAccount;
import com.testbank.bank.entity.TxnHistory;
import com.testbank.bank.entity.User;
import com.testbank.bank.repository.BankAccountRepo;
import com.testbank.bank.repository.TxnHistoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class BankApplication implements CommandLineRunner {

	@Autowired
	TxnHistoryRepo txnHistoryRepo;

	@Autowired
	BankAccountRepo bankAccountRepo;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		txnHistoryRepo.saveAll(getTxnHistoryList());
		log.info("Pre requisit Data inserted");
		createAccount();
	}

	private List<TxnHistory> getTxnHistoryList() {
		createAccount();
//		TxnHistory txnHistory1 = new TxnHistory(UUID.randomUUID().toString(), "Atique1", "Axis Bank", "1500", "DBS Bank", "1500", TxnType.CREDIT, TxnStatus.FAILED);
//		TxnHistory txnHistory2 = new TxnHistory(UUID.randomUUID().toString(), "Atique2", "Axis Bank", "1500", "DBS Bank", "1500", TxnType.CREDIT, TxnStatus.SUCCESS);
//		TxnHistory txnHistory3 = new TxnHistory(UUID.randomUUID().toString(), "Atique3", "Axis Bank", "1500", "DBS Bank", "1500", TxnType.DEBIT, TxnStatus.PENDING);
//		return List.of(txnHistory1, txnHistory2, txnHistory3);
		return null;
	}

	private void createAccount() {
		User user1 = new User("Atique", "atique@gmail.com", "9964902367", "BUAXXXXX2J", "XXXX-XXXX-XXXX-XXXX");
		BankAccount atiqueAccount = new BankAccount(UUID.randomUUID().toString(), "Axis Bank", user1, "999999999999999", AccountType.Current, 50000d);

		User user2 = new User("Talaha", "talaha@gmail.com", "7065176178", "BUAXXXXX2J", "XXXX-XXXX-XXXX-XXXX");
		BankAccount talahaAccount = new BankAccount(UUID.randomUUID().toString(), "Axis Bank", user2, "9844567890987654", AccountType.Current, 50000d);

		List<BankAccount> bankAccounts = new ArrayList<>();
		bankAccounts.add(atiqueAccount);
		bankAccounts.add(talahaAccount);
		bankAccountRepo.saveAll(bankAccounts);
	}
}
