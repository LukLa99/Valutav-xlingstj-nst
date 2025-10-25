package com.example.valutavaxling.service;

import com.example.valutavaxling.data.CurrencyCode;
import com.example.valutavaxling.integration.RiksBankenApiClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VaxlingService {

    private final RiksBankenApiClient riksBankenApiClient;

    public VaxlingService(RiksBankenApiClient riksBankenApiClient) {
        this.riksBankenApiClient = riksBankenApiClient;
    }

    public String getExchangeRateFromDate(final CurrencyCode fromCurrency, final CurrencyCode toCurrency, final LocalDate toDate) {
    return riksBankenApiClient.getExchangeRateForDate(fromCurrency, toCurrency, toDate);
    }
}
