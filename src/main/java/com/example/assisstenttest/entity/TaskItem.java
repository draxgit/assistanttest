package com.example.assisstenttest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class TaskItem {
        private Long id;
        private String brand;
        private String article;
        private String priceThreshold;
        private Boolean isActive;
        private Integer cnt;

        @JsonIgnore
        public String getFieldValuesArray() {
            return
                    brand + "," +
                            article + "," +
                            priceThreshold + "," +
                            isActive + "," +
                            cnt;
        }
    }

