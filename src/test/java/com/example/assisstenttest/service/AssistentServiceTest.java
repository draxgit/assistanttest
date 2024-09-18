package com.example.assisstenttest.service;

import com.example.assisstenttest.entity.ScanItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AssistentServiceTest {
    private  final RestTemplate restTemplate = new RestTemplate();

    @Test
    void testHandlePriceScanningFetch() {
        // Установите URL вашего API
        String url = "http://192.168.0.51:30549/api/v1/price-miner/scan/fetch";

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer f4228ea2-d379-4ef8-9d5c-bbaa69db3f88");
        headers.set("X-Company-Id", "43611C800F199A3145B0");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<ScanItem>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );

        List<ScanItem> scanItems = response.getBody();
        System.out.println(scanItems);
    }
}