package org.learing.p2p.model;

public class EntitlementData {
    private  String k1Number;
    private  String tradeType;
    private  double entryPrice;
    private  double exitPrice;
    private  double lotSize;
    private  double profit;
    public String getK1Number() {
        return k1Number;
    }

    public void setK1Number(String k1Number) {
        this.k1Number = k1Number;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
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

    public double getLotSize() {
        return lotSize;
    }

    public void setLotSize(double lotSize) {
        this.lotSize = lotSize;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }


}
