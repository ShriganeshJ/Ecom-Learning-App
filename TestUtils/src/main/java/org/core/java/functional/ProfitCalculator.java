package org.core.java.functional;
@FunctionalInterface
public interface ProfitCalculator {
    public abstract Double calculateProfit(int lotSize,double entryPrice,double exitPrice);
}
