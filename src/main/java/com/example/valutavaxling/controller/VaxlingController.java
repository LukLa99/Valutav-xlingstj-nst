package com.example.valutavaxling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("valuta")
public class VaxlingController {

    @GetMapping("/get")
    public String getValuta() {
        return "Hello";

    }
}
