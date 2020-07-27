package com.ernokun.cryptocurrencytracker.services;

import com.ernokun.cryptocurrencytracker.models.coinranking.Coin;
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
public class CryptoCoinDataService {

    // The url to the API
    private String url = "https://api.coinranking.com/v1/public/coins?base=eur&sort=coinranking";


    // The current data.
    private CryptoCoinData cryptoCoinData;


    @Autowired
    private JsonParsingService jsonParsingService;


    // Sends a GET request to the API every minute.
    @PostConstruct
    @Scheduled(cron = "1 * * * * *")
    public void fetchData() {
        try {
            CryptoCoinData cryptoCoinData_new = jsonParsingService.parse(url);

            this.cryptoCoinData = cryptoCoinData_new;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Passes the data to the controller.
    public CryptoCoinData getCryptoCoinData() {
        return cryptoCoinData;
    }


    // Gets the current date
    public String getCurrentDate() {
        LocalDateTime date = LocalDateTime.now();

        String currentDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return currentDate;
    }


    public Coin[] getCurrentPageCoinData(int page, int pageSize, Coin[] allCoins) {
        Coin[] coins = new Coin[pageSize];

        int startPage = page * pageSize;
        int endPage = startPage + pageSize;

        int coinArrayIndex = 0;

        // Get cryotocurrency data for current page.
        for (int i = startPage; i < endPage; i++) {

            // if out of bounds - break.
            if (i >= allCoins.length)
                break;

            coins[coinArrayIndex++] = allCoins[i];
        }

        return coins;
    }

}
