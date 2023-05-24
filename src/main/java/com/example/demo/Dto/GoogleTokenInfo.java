package com.example.demo.Dto;

public class GoogleTokenInfo {
    private String aud;
    private String sub;
    private String email;
    // Add other fields as needed

    // Getters and setters

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
