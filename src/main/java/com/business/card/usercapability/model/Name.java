package com.business.card.usercapability.model;

public class Name {
    private String firstName;
    private String lastName;
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Name() {
    }
    @Override
    public String toString() {
        return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
    
}
