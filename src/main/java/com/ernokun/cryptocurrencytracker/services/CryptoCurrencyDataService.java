package com.ernokun.cryptocurrencytracker.services;

import com.ernokun.cryptocurrencytracker.models.coinranking.CryptoCoinData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@EnableScheduling
public class CryptoCurrencyDataService {

    // The url to the API
    private String url = "https://api.coinranking.com/v1/public/coins?base=eur&sort=coinranking";


    // The current data.
    private CryptoCoinData cryptoCurrencyData;


    @Autowired
    private JsonParsingService jsonParsingService;


    // Sends a GET request to the API every minute.
    @PostConstruct
    @Scheduled(cron = "1 * * * * *")
    public void fetchData() {
        try {
            CryptoCoinData cryptoCurrencyData_new = jsonParsingService.parse(url);

            this.cryptoCurrencyData = cryptoCurrencyData_new;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Passes the data to the controller.
    public CryptoCoinData getCryptoCurrencyData() {
        return cryptoCurrencyData;
    }


    // Gets the current date
    public String getCurrentDate() {
        LocalDateTime date = LocalDateTime.now();

        String currentDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return currentDate;
    }

}
