package com.example.cryptoautomation.controller;

import com.example.cryptoautomation.service.UpbitSlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UpbitSlackService slackService;

    @GetMapping("/api/v1/ticker/{market}")
    public void test(@PathVariable String market) {
        slackService.execute(market);
    }


}
