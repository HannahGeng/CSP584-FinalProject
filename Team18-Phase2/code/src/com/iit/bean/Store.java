package com.iit.bean;

public class Store {
    Integer storeid;
    String state;
    String city;
    String street;
    String zipcode;
    String address;

    public Store() {
    }

    public Store(Integer storeid, String state, String city, String street, String zipcode, String address) {
        this.storeid = storeid;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
