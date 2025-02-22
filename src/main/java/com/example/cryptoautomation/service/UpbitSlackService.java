package com.example.cryptoautomation.service;

import com.example.cryptoautomation.http.SlackHttpClient;
import com.example.cryptoautomation.http.UpbitHttpClient;
import com.example.cryptoautomation.http.UpbitTickerDto;
import com.example.cryptoautomation.repository.RepostHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *  Upbit 에 서 받은 데이터 Slack 에 날리는 비즈니스 로직
 */
@Service
@RequiredArgsConstructor
public class UpbitSlackService {
    private final SlackHttpClient slackHttpClient;
    private final UpbitHttpClient upbitHttpClient;
    private final RepostHistoryRepository repository;

    public void execute(String market){

        // upbit
        UpbitTickerDto tickerByMarket = upbitHttpClient.getTickerByMarket(market);

//         slack send
        StringBuilder sb = new StringBuilder();
        sb.append("[실시간 데이터]");
        sb.append(market);
        sb.append("price = ");
        sb.append(tickerByMarket.getTrade_price());
        slackHttpClient.send(sb.toString());

        repository.save(market, String.valueOf(tickerByMarket.getTrade_price()));
    }
}
