package com.example.chatgpt;

import com.example.chatgpt.service.CustomChatGpt;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Scanner;

@SpringBootTest
class ChatGptApplicationTests {

    @Test
    void contextLoads() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String apiKey = "自己的ApiKey";
        CustomChatGpt customChatGpt = new CustomChatGpt(apiKey);
        // 根据自己的网络设置吧
        customChatGpt.setResponseTimeout(20000);
        while (true) {
            System.out.print("\n请输入问题(q退出)：");
            String question = new Scanner(System.in).nextLine();
            if ("q".equals(question)) break;
            long start = System.currentTimeMillis();
            String answer = customChatGpt.getAnswer(httpClient, question);
            long end = System.currentTimeMillis();
            System.out.println("该回答花费时间为：" + (end - start) / 1000.0 + "秒");
            System.out.println(answer);
        }
        httpClient.close();
    }

}
