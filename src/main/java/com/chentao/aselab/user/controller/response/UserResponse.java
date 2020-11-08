package com.chentao.aselab.user.controller.response;


import com.chentao.aselab.user.entity.User;

public class UserResponse {
    private Long id;

    private String username;

    private String email;
    private String organization;
    private String region;
    private String fullName;
    private String authority;

    public UserResponse() {
    }

    public UserResponse(Long id, String username, String email, String organization, String region, String fullName, String authority) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.organization = organization;
        this.region = region;
        this.fullName = fullName;
        this.authority = authority;
    }
    public UserResponse(User user){
        if(user==null){
            return;
        }
        this.id=user.getId();
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.organization=user.getOrganization();
        this.region=user.getRegion();
        this.fullName=user.getFullName();
        this.authority=user.getAuthority();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
