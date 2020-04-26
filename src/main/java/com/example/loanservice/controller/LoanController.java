package com.example.loanservice.controller;

import com.example.loanservice.DAL.LoanDAL;
import com.example.loanservice.model.Loan;
import com.example.loanservice.repository.LoanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoanDAL loanDAL;

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public List<Loan> getAllLoans() {
        LOG.info("Getting all Loans.");
        return loanDAL.findAll();
    }

    @RequestMapping(value = "/{loanId}", method = RequestMethod.GET)
    public Loan getLoan(@PathVariable String loanId) {
        LOG.info("Getting loan with ID: {}.", loanId);
        return loanDAL.findByLoanId(loanId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Loan addNewLoan(@RequestBody Loan loan) {
        LOG.info("Saving Loan.");
        return loanDAL.save(loan);
    }

    @RequestMapping(value = "/getLoansByCustomer/{customerId}")
    public List<Loan> getLoanByCustomer(@PathVariable String customerId) {
        LOG.info("Saving Loan.");
        return loanDAL.findByCustomerId(customerId);
    }

    @RequestMapping(value = "/version")
    public String version() {
        String version = System.getenv("VERSION");
        String ver = version!=null?version: "v1";
        LOG.info("Version ----> " + ver);
        return "Hi from Loan service version ---> " + ver;
    }
}
