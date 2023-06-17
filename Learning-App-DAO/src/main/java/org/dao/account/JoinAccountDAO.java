package org.dao.account;

import org.dao.tx.AccountStaement;

public class JoinAccountDAO {

    private double balanceAmountFirstHolder;
    private double balanceAmountSecondHolder;

    private AccountStaement firstHolderAccountStatement;
    private AccountStaement secondHolderAccountStatement;

    public double getBalanceAmountFirstHolder() {
        return balanceAmountFirstHolder;
    }

    public void setBalanceAmountFirstHolder(double balanceAmountFirstHolder) {
        this.balanceAmountFirstHolder = balanceAmountFirstHolder;
    }

    public double getBalanceAmountSecondHolder() {
        return balanceAmountSecondHolder;
    }

    public void setBalanceAmountSecondHolder(double balanceAmountSecondHolder) {
        this.balanceAmountSecondHolder = balanceAmountSecondHolder;
    }

    public AccountStaement getFirstHolderAccountStatement() {
        return firstHolderAccountStatement;
    }

    public void setFirstHolderAccountStatement(AccountStaement firstHolderAccountStatement) {
        this.firstHolderAccountStatement = firstHolderAccountStatement;
    }

    public AccountStaement getSecondHolderAccountStatement() {
        return secondHolderAccountStatement;
    }

    public void setSecondHolderAccountStatement(AccountStaement secondHolderAccountStatement) {
        this.secondHolderAccountStatement = secondHolderAccountStatement;
    }


}
