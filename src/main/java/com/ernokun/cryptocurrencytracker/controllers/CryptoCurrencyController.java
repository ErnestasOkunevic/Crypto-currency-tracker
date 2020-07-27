package com.ernokun.cryptocurrencytracker.controllers;

import com.ernokun.cryptocurrencytracker.models.coinranking.Coin;
import com.ernokun.cryptocurrencytracker.models.coinranking.CryptoCoinData;
import com.ernokun.cryptocurrencytracker.models.coinranking.Data;
import com.ernokun.cryptocurrencytracker.services.CryptoCoinDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CryptoCurrencyController {

    @Autowired
    private CryptoCoinDataService cryptoCurrencyDataService;

    // How many rows of cryptocurrency data will be shown in the index.html table.
    public static final int PAGE_ROW_AMOUNT = 10;


    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(defaultValue = "0") int page) {

        CryptoCoinData cryptoCurrencyData =
                cryptoCurrencyDataService.getCryptoCoinData();

        Data data = cryptoCurrencyData.getData();

        // All of the coins.
        Coin[] allCoins = data.getCoins();


        // The coins that will be shown in the table.
        Coin[] coins = cryptoCurrencyDataService.getCurrentPageCoinData(
                page, PAGE_ROW_AMOUNT, allCoins);

        // How many pages should the table contain.
        int pageCount = (int) Math.ceil((1.0 * allCoins.length) / PAGE_ROW_AMOUNT);


        model.addAttribute("pageCount",
                pageCount);

        model.addAttribute("currentDate",
                cryptoCurrencyDataService.getCurrentDate());

        model.addAttribute("cryptoCurrencyData",
                cryptoCurrencyData);

        model.addAttribute("coins",
                coins);

        model.addAttribute("coinAmount",
                allCoins.length);

        model.addAttribute("currentPage",
                page);


        return "index";
    }

}
