package com.iit.bean;

public class OrderItem {
    private int itemid;
    private int orderid;
    private int count;
    private String model;
    private double amount;
    private double price;
    private String image;
    private String manufacturer;
    private String condition;
    private double discount;
    private int warranty;
    private int productid;

    public OrderItem() {
    }

    public OrderItem(int itemid, int orderid, int count, String model, double amount, double price, String image, String manufacturer, String condition, double discount, int warranty, int productid) {
        this.itemid = itemid;
        this.orderid = orderid;
        this.count = count;
        this.model = model;
        this.amount = amount;
        this.price = price;
        this.image = image;
        this.manufacturer = manufacturer;
        this.condition = condition;
        this.discount = discount;
        this.warranty = warranty;
        this.productid = productid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }
}
