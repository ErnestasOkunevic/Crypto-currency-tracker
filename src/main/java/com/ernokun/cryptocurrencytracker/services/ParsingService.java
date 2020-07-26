package com.ernokun.cryptocurrencytracker.services;

import com.ernokun.cryptocurrencytracker.models.coinranking.CryptoCoinData;

public interface ParsingService {

    CryptoCoinData parse(String url);

}
