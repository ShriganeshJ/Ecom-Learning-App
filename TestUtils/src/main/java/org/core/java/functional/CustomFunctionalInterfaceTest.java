package org.core.java.functional;

public class CustomFunctionalInterfaceTest {

    public static void main(String[] args) {
        ProfitCalculator profitCalculator = (lot, entry, exit) -> (exit - entry) * lot;
        Double profit = profitCalculator.calculateProfit(1000, 41.30, 45.30);

        System.out.println("Profit is::" + profit);

    }
}
