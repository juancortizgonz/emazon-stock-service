package com.emazon.stock_service.domain.model;

import java.util.List;

public class Item {
    private Long itemId;
    private String itemName;
    private String itemDescription;
    private Integer itemQuantity;
    private Double itemPrice;
    private Long brandId;
    private List<Long> categoryIdList;

    public Item() {
    }

    public Item(Long itemId, String itemName, String itemDescription, Integer itemQuantity, Double itemPrice, Long brandId, List<Long> categoryIdList) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.brandId = brandId;
        this.categoryIdList = categoryIdList;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public List<Long> getCategoryIdList() {
        return categoryIdList;
    }

    public void setCategoryIdList(List<Long> categoryIdList) {
        this.categoryIdList = categoryIdList;
    }
}
