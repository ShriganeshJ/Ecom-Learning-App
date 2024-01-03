package com.ecom.pojo;

public class TradeInfo {

    private String tradeType;

    @Override
    public String toString() {
        return "TradeInfo{" +
                "tradeType='" + tradeType + '\'' +
                ", symbol='" + symbol + '\'' +
                ", entryPrice=" + entryPrice +
                ", exitPrice=" + exitPrice +
                ", stopLoss=" + stopLoss +
                ", positionSize=" + positionSize +
                ", profit=" + profit +
                '}';
    }

    private String symbol;
    private double entryPrice;
    private double exitPrice;
    private double stopLoss;
    private double positionSize;
    private double profit;

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(double entryPrice) {
        this.entryPrice = entryPrice;
    }

    public double getExitPrice() {
        return exitPrice;
    }

    public void setExitPrice(double exitPrice) {
        this.exitPrice = exitPrice;
    }

    public double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;
    }

    public double getPositionSize() {
        return positionSize;
    }

    public void setPositionSize(double positionSize) {
        this.positionSize = positionSize;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }



}
