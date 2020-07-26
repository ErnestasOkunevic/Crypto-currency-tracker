package com.ernokun.cryptocurrencytracker.models.coinranking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats {

    private long total;

    public Stats() {}

    public Stats(long total) {
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "total=" + total +
                '}';
    }
}
