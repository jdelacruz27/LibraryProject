package com.sparta.jian.libraryproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_entity", schema = "library")
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userRole;
    private Integer UserEnabled;

    public UserEntity(String userName, String userPassword, String userRole, Integer userEnabled) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        UserEnabled = userEnabled;
    }

    public UserEntity() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Integer getUserEnabled() {
        return UserEnabled;
    }

    public void setUserEnabled(Integer userEnabled) {
        UserEnabled = userEnabled;
    }
}
