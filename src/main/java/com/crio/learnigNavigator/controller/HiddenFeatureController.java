package com.crio.learnigNavigator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/hidden-feature")
public class HiddenFeatureController {

    private final RestTemplate restTemplate = new RestTemplate();

    private record fact(Integer number, String text) {}

    @GetMapping("/{number}")
    public Object getHiddenFeature(@PathVariable Integer number) {
        URI url = URI.create("http://numbersapi.com/" + number + "?notfound=floor&fragment");
        String text = restTemplate.getForObject(url, String.class);
        return new fact(number, text);
    }
}
