package com.example.valutavaxling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public record ExchangeRate(
        @Id @GeneratedValue int id,
        Boolean swedishBankDay,
        String calenderDate,
        String weekYear,
        String weekNumber,
        String quarterNumber
) {
}
