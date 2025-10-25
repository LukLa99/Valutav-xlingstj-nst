package com.example.valutavaxling.repository;

import com.example.valutavaxling.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<ExchangeRate, Long> {

}
