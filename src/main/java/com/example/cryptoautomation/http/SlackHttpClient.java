package com.example.cryptoautomation.http;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 1. Upbit 에서 Api 수신 후
 * 2. 슬랙에 메세지를 날릴 클래스
 */
@Component
public class SlackHttpClient {
    public void send(String message){

        try {
            Slack instance = Slack.getInstance();

            // 요청을 보내기 위한 payload객체 생성
            Payload payload = Payload.builder()
                    .text(message)
                    .build();

            // webhooks 주소  보낼 데이터
            instance.send("https://hooks.slack.com/services/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", payload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
