package org.dao.account;

import org.dao.tx.AccountStaement;

import java.sql.Timestamp;

public class SaveingAccountDAO {
    private double balanceAmount;

    private AccountStaement accountStaement;

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public AccountStaement getAccountStaement() {
        return accountStaement;
    }

    public void setAccountStaement(AccountStaement accountStaement) {
        this.accountStaement = accountStaement;
    }


}
