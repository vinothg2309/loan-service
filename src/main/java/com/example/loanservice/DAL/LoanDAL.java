package com.example.loanservice.DAL;

import com.example.loanservice.model.Loan;
import org.springframework.data.geo.CustomMetric;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface LoanDAL extends MongoRepository<Loan, String> {

    public Loan save(Loan loan);

    public List<Loan> findAllBy();

    public Loan findByLoanId(String loanId);

    public List<Loan> findByCustomerId(String customerId);


}
