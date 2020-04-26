package com.example.loanservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document
public class Loan {

    @Id
    private String loanId;
    private String amount;
    private String tenure;
    private String interest;
    private String customerId;
    private String type;
    private Date creationDate = new Date();
    private Map<String, String> loanSettings = new HashMap<>();


    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Map<String, String> getLoanSettings() {
        return loanSettings;
    }

    public void setLoanSettings(Map<String, String> loanSettings) {
        this.loanSettings = loanSettings;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Loan(String loanId, String amount, String tenure, String interest, String customerId, String type) {
        this.loanId = loanId;
        this.amount = amount;
        this.tenure = tenure;
        this.interest = interest;
        this.customerId = customerId;
        this.type = type;
    }
}
