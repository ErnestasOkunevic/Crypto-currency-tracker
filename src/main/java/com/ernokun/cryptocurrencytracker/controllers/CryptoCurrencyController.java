package com.ernokun.cryptocurrencytracker.controllers;

import com.ernokun.cryptocurrencytracker.models.coinranking.Coin;
import com.ernokun.cryptocurrencytracker.models.coinranking.CryptoCoinData;
import com.ernokun.cryptocurrencytracker.models.coinranking.Data;
import com.ernokun.cryptocurrencytracker.services.CryptoCurrencyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CryptoCurrencyController {

    @Autowired
    private CryptoCurrencyDataService cryptoCurrencyDataService;


    @GetMapping("/")
    public String index(Model model) {

        CryptoCoinData cryptoCurrencyData = cryptoCurrencyDataService.getCryptoCurrencyData();

        Data data = cryptoCurrencyData.getData();

        Coin[] coins = data.getCoins();


        model.addAttribute("currentDate",
                cryptoCurrencyDataService.getCurrentDate());

        model.addAttribute("cryptoCurrencyData",
                cryptoCurrencyData);

        model.addAttribute("coins",
                coins);

        model.addAttribute("coinAmount",
                coins.length);


        return "index";
    }

}
