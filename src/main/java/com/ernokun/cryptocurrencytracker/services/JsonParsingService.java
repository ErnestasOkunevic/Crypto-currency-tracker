package com.ernokun.cryptocurrencytracker.services;

import com.ernokun.cryptocurrencytracker.models.coinranking.CryptoCoinData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonParsingService implements ParsingService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public CryptoCoinData parse(String url) {
        return restTemplate.getForObject(url, CryptoCoinData.class);
    }

}
