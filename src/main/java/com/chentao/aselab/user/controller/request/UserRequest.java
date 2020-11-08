package com.chentao.aselab.user.controller.request;

public class UserRequest {

    private String username;
    private String email;
    private String password;
    private String organization;
    private String region;
    private String fullName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public boolean isNull(){
        return strIsNull(username)||strIsNull(email)||strIsNull(organization)
                ||strIsNull(region)||strIsNull(fullName)||strIsNull(password);
    }
    private boolean strIsNull(String string){
        return string==null || string.trim().equals("");
    }
}
