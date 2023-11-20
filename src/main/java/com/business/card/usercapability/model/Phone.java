package com.business.card.usercapability.model;

public class Phone {
    private String countryCode;
    private String number;
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Phone(String countryCode, String number) {
        this.countryCode = countryCode;
        this.number = number;
    }
    public Phone() {
    }
    @Override
    public String toString() {
        return "Phone [countryCode=" + countryCode + ", number=" + number + "]";
    }
    
}
