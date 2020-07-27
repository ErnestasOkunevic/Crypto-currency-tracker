package com.ernokun.cryptocurrencytracker.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyErrorController implements ErrorController {


    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
