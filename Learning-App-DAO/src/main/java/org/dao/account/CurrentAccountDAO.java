package org.dao.account;

import org.dao.tx.AccountStaement;

public class CurrentAccountDAO {

    private AccountStaement AccountStatement;
    private  double ccBalance;
    private double approvedAccAmount;

    public AccountStaement getAccountStatement() {
        return AccountStatement;
    }

    public void setAccountStatement(AccountStaement accountStatement) {
        AccountStatement = accountStatement;
    }

    public double getCcBalance() {
        return ccBalance;
    }

    public void setCcBalance(double ccBalance) {
        this.ccBalance = ccBalance;
    }

    public double getApprovedAccAmount() {
        return approvedAccAmount;
    }

    public void setApprovedAccAmount(double approvedAccAmount) {
        this.approvedAccAmount = approvedAccAmount;
    }



}
