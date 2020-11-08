package com.chentao.aselab.user.entity;

import com.chentao.aselab.user.controller.request.UserRequest;
import org.springframework.util.DigestUtils;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;
    private String email;
    private String organization;
    private String region;
    private String fullName;
    private String authority;

    public User() {
    }

    public User(Long id, String username, String password, String email, String organization, String region, String fullName, String authority) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.organization = organization;
        this.region = region;
        this.fullName = fullName;
        this.authority = authority;
    }
    public User(UserRequest userRequest){
        if(userRequest==null){
            return;
        }
        this.username=userRequest.getUsername();
        this.email=userRequest.getEmail();
        this.fullName=userRequest.getFullName();
        this.organization=userRequest.getOrganization();
        this.region=userRequest.getRegion();
        this.password= DigestUtils.md5DigestAsHex(userRequest.getPassword().getBytes());
        this.authority="USER";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
