package org.learing.pubsub.pojo;

import java.io.Serializable;

public class GoldRate implements Serializable {
    private double localGold22KRates;
    private double localGold24Krates;

    private double gloablGold22Krates;
    private double gloabalGOld24Krates;

    public double getLocalGold22KRates() {
        return localGold22KRates;
    }

    public void setLocalGold22KRates(double localGold22KRates) {
        this.localGold22KRates = localGold22KRates;
    }

    public double getLocalGold24Krates() {
        return localGold24Krates;
    }

    public void setLocalGold24Krates(double localGold24Krates) {
        this.localGold24Krates = localGold24Krates;
    }

    public double getGloablGold22Krates() {
        return gloablGold22Krates;
    }

    public void setGloablGold22Krates(double gloablGold22Krates) {
        this.gloablGold22Krates = gloablGold22Krates;
    }

    public double getGloabalGOld24Krates() {
        return gloabalGOld24Krates;
    }

    public void setGloabalGOld24Krates(double gloabalGOld24Krates) {
        this.gloabalGOld24Krates = gloabalGOld24Krates;
    }




}
