package com.patrickriibeiro.hexagonal.application.core.domain;

public class Address {

    private String street;

    private String city;

    private String estate;

    public Address(String street, String city, String estate) {
        this.street = street;
        this.city = city;
        this.estate = estate;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
