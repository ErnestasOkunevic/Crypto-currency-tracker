package com.ernokun.cryptocurrencytracker.models.coinranking;

public class CryptoCoinData {

    private Data data;

    public CryptoCoinData() {}

    public CryptoCoinData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CryptoCoinData{" +
                "data=" + data +
                '}';
    }
}
