package com.example.assisstenttest.entity;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class LogItem {
    private String brand;
    private String article;
    private String partName;
    private Double price;
    private String currency;
    private Integer quantity;
    private String vendorName;
    private String vendorId;
    private String warehouse;
    private Boolean promo;
}
