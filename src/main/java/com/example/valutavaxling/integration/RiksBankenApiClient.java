package com.example.valutavaxling.integration;

import com.example.valutavaxling.data.CurrencyCode;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import lombok.Data;

import java.time.LocalDate;

@Component
@Data
public class RiksBankenApiClient {
    private WebClient webClient;

    @Value("${external-api.exchange-rate-api}")
    String riksBankApi;

    @PostConstruct
    public void init() {
        this.webClient =
                WebClient.builder()
                        .baseUrl(riksBankApi)
                        .build();
    }

    public String getExchangeRateForDate(CurrencyCode fromCurrency, CurrencyCode toCurrency, LocalDate toDate) {
        return webClient.get().uri(uriBuilder -> uriBuilder
                        .path("/CrossRateAggregates/{from}/{to}/W/{date}")
                        .build(fromCurrency, toCurrency, toDate.toString()))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
