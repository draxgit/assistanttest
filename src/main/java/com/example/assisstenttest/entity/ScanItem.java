package com.example.assisstenttest.entity;

import lombok.*;

import java.util.List;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @EqualsAndHashCode

    public class ScanItem {
        private TaskItem taskItem;
        private String brand;
        private String article;
        private String partName;
        private Double price;
        private String currency;
        private Integer quantity;
        private String vendorName;
        private String vendorId;
        private String warehouse;
        private boolean isVendorAuthorized;
        private boolean isPriceApproved;
        private Double approvedPrice;
        private String approvalVendorName;
        private String approvalWarehouse;
        private Integer approvalQuantity;
        private boolean authorized;
        private boolean approved;
        private List<String> fieldValuesArray;
        private Boolean isDeficit;
        private Boolean isPromo;

        public boolean isVendorAuthorized() {
            return isVendorAuthorized;
        }

        public void setIsAuthorized(boolean isAuthorized) {
            this.isVendorAuthorized = isAuthorized;
        }

        public void setIsApproved(boolean isApproved) {
            this.isPriceApproved = isApproved;
        }

        public String[] getFieldValuesArray() {
            return List.of(
                    brand.replace(";", ""),
                    article.replace(";", ""),
                    partName.replace(";", ""),
                    taskItem.getPriceThreshold().replace(";", ""),
                    String.valueOf(Math.round(price)).replace(";", ""),
                    String.valueOf(quantity).replace(";", ""),
                    warehouse != null ? warehouse.replace(";", "") : "Склад не указан",
                    vendorName.replace(";", ""),
                    String.valueOf(isVendorAuthorized ? 1 : 0),
                    String.valueOf(isPriceApproved ? 1 : 0),
                    String.valueOf(Math.round(approvedPrice)).replace(";", ""),
                    String.valueOf(approvalQuantity != null ? approvalQuantity : 0).replace(";", ""),
                    approvalVendorName.replace(";", ""),
                    approvalWarehouse.replace(";", "")
            ).toArray(new String[0]);
        }

        public ScanItem(LogItem logItem) {

            TaskItem newScanItem = new TaskItem();
            newScanItem.setArticle(logItem.getArticle());
            newScanItem.setBrand(logItem.getBrand());
            newScanItem.setPriceThreshold(String.valueOf(logItem.getPrice()));
            this.taskItem = newScanItem;
            this.brand = logItem.getBrand();
            this.article = logItem.getArticle();
            this.partName = logItem.getPartName();
            this.price = logItem.getPrice();
            this.currency = logItem.getCurrency();
            this.quantity = logItem.getQuantity();
            this.vendorName = logItem.getVendorName();
            this.vendorId = logItem.getVendorId();
            this.warehouse = logItem.getWarehouse();
            this.approvedPrice = 0d;
            this.approvalVendorName = "-";
            this.approvalWarehouse = "-";
            this.approvalQuantity = 0;
        }
    }


