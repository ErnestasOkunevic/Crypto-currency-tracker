package com.ernokun.cryptocurrencytracker.models.coinranking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {

    private String name;
    private String price;
    private String description;
    private long rank;
    private float change;

    public Coin() {}

    public Coin(String name, String price, String description, long rank, float change) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.rank = rank;
        this.change = change;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return String.format("%.2f", Double.parseDouble(price));
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", rank=" + rank +
                ", change=" + change +
                '}';
    }
}
