package com.ecom.pojo;

public class CurrencyTrade {

    private String k1Number;
    private String exchangeName;
    private String session;
    private UserInfo userInfo;
    private  TradeInfo tradeInfo;

    @Override
    public String toString() {
        return "CurrencyTrade{" +
                "k1Number='" + k1Number + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", session='" + session + '\'' +
                ", userInfo=" + userInfo +
                ", tradeInfo=" + tradeInfo +
                '}';
    }

    public String getK1Number() {
        return k1Number;
    }

    public void setK1Number(String k1Number) {
        this.k1Number = k1Number;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public TradeInfo getTradeInfo() {
        return tradeInfo;
    }

    public void setTradeInfo(TradeInfo tradeInfo) {
        this.tradeInfo = tradeInfo;
    }



}
