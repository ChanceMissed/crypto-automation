package com.example.cryptoautomation.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpbitHttpClient {
    private final HttpClient httpClient;


    public UpbitTickerDto getTickerByMarket(String market)  {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept", "application/json");

            //1.  응답값 가져오기
            String execute = httpClient.execute(
                    "https://api.upbit.com/v1/ticker?markets=" + market,
                    HttpMethod.GET,
                    headers
            );
            // 2. 가져온 응답값을 List형태로 변환해주기
            ObjectMapper objectMapper = new ObjectMapper();
            // String 으로 읽은 데이터를 objectMapper 을 이용해서 new TypeReference 로 변환 !
            return objectMapper.readValue(
                    execute,
                    new TypeReference<List<UpbitTickerDto>>() {
                    }).stream().findFirst().get();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
