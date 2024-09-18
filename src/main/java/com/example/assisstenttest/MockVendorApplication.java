package com.example.assisstenttest;

import com.example.assisstenttest.entity.ScanItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@SpringBootApplication
public class MockVendorApplication {

    public static void gitmain(String[] args) {
        SpringApplication.run(MockVendorApplication.class, args);

        Test.test();

//        List<String> brands = new BrandService().getBrands("asd123");
//        System.out.println(brands);
//
////        RestTemplate restTemplate = new RestTemplate();
////        ObjectMapper objectMapper = new ObjectMapper();
//        List<String> imageUrls = new RandomImageService().getImageUrls(1);
////        List<String> imageUrls = new RandomImageService(restTemplate, objectMapper).getImageUrl(1);
//        System.out.println(imageUrls);
//
//        int imagePageNumber1 = 25 % 25;
//        int imagePageNumber2 = 26 % 25;
//        int imagePageNumber3 = 0 % 25;
//        int imagePageNumber4 = 100 % 25;
//        System.out.println(imagePageNumber1 +" " + imagePageNumber2 +" " + imagePageNumber3 +" " + imagePageNumber4);

    }

    class Test {
        private static RestTemplate restTemplate = new RestTemplate(); // Инициализация RestTemplate
        private static final String brandApiUrl = "https://api.qwep.ru/get_short_articles_list/%s";
        public static void testHandlePriceScanningFetch() {
            RestTemplate restTemplate = new RestTemplate(); // Инициализация RestTemplate

            // Установите URL вашего API
            String url = "http://192.168.0.51:30549/api/v1/price-miner/scan/fetch";

            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, "Bearer f4228ea2-d379-4ef8-9d5c-bbaa69db3f88");
            headers.set("X-Company-Id", "43611C800F199A3145B0");
            headers.set("Content-Type", "application/json");

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<List<ScanItem>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<>() {}pwd
            );

            List<ScanItem> scanItems = response.getBody();
            System.out.println(scanItems);
        }
        public static void test() {
            String urlWithArticle = String.format(brandApiUrl, "01244");

            String responseBody;
            try {
                // Выполняем запрос с использованием exchange
                ResponseEntity<String> response = restTemplate.exchange(
                        urlWithArticle, // URL запроса
                        HttpMethod.GET, // Метод HTTP-запроса
                        null, // Тело запроса (null для GET)
                        String.class // Ожидаемый тип ответа
                );

                // Получаем тело ответа
                responseBody = response.getBody();
                System.out.println("Response: " + responseBody);
            } catch (Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }
}