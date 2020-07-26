package com.ernokun.cryptocurrencytracker.models.coinranking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private Coin[] coins;

    private Stats stats;

    public Data() {}

    public Data(Coin[] coins, Stats stats) {
        this.coins = coins;
        this.stats = stats;
    }

    public Coin[] getCoins() {
        return coins;
    }

    public void setCoins(Coin[] coins) {
        this.coins = coins;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Data{" +
                "coins=" + Arrays.toString(coins) +
                ", stats=" + stats +
                '}';
    }
}
