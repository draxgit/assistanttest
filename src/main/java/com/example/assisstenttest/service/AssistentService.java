package com.example.assisstenttest.service;

import com.example.assisstenttest.entity.ScanItem;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service

public class AssistentService {

    private  final RestTemplate restTemplate = new RestTemplate();

    public void test () {
        List <ScanItem> scanItems = new ArrayList<>();
        String url = "http://192.168.0.51:30549/api/v1/price-miner/scan/fetch";
        HttpHeaders headers = new HttpHeaders();
        String accessToken = "c72886dff3c39abf35d8b09e3dc10d861e3878a0";
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("X-Company-Id", "4AA76767AACE81C14B7D");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<ScanItem>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );

        System.out.println(response.getBody());
    }


}
