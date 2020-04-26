package com.example.loanservice;

import com.example.loanservice.DAL.LoanDAL;
import com.example.loanservice.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanServiceApplication  implements CommandLineRunner {

	@Autowired
	private LoanDAL loanDAL;

	public static void main(String[] args) {
		SpringApplication.run(LoanServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.loanDAL.save(new Loan("1","1000000","10 yrs","9%","1","Personal Loan"));
		this.loanDAL.save(new Loan("2","2000000","20 yrs","8%","1","Mortgage"));

		this.loanDAL.save(new Loan("3","100000","5 yrs","10%","2","Personal Loan"));
		this.loanDAL.save(new Loan("4","3000000","30 yrs","8%","2","Mortgage"));
	}
}
