package com.example.minor;

import com.example.minor.repository.TxnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinorApplication implements CommandLineRunner {


	@Autowired
	private TxnRepository txnRepository;

	public static void main(String[] args) {
		SpringApplication.run(MinorApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		txnRepository.updateTxnCreatedOn();
	}
}
