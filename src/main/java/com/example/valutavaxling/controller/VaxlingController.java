package com.example.valutavaxling.controller;

import com.example.valutavaxling.data.CurrencyCode;
import com.example.valutavaxling.service.VaxlingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("valuta")
public class VaxlingController {

    private final VaxlingService vaxlingService;

    public VaxlingController(VaxlingService vaxlingService) {
        this.vaxlingService = vaxlingService;
    }

    @GetMapping("/get/{fromCurrency}/{toCurrency}/{date}")
    public String getExchangeRates(@PathVariable final CurrencyCode fromCurrency,
                                   @PathVariable final CurrencyCode toCurrency,
                                   @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate date) {
        return vaxlingService.getExchangeRateFromDate(fromCurrency, toCurrency, date);
    }
}
