package com.business.card.usercapability.model;

public class Social {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Social(String email) {
        this.email = email;
    }

    public Social() {
    }

    @Override
    public String toString() {
        return "Social [email=" + email + "]";
    }
    
}
