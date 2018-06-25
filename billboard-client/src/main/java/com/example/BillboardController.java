package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class BillboardController {

    private final RestTemplate restTemplate;

    public BillboardController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/message")
    public String get(){
        Quote quote = restTemplate.exchange(RequestEntity
                .get(URI.create("http://message-service/quotes/1"))
                .header("Content-Type", "application/json")
                .build(), Quote.class).getBody();
        return quote.getQuote() + " -- " + quote.getAuthor();
    }
}
