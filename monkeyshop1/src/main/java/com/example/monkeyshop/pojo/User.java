package com.example.monkeyshop.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer id;
    private String userId ;
    private String userName ;
    private String userPassword ;
    private String userSex ;
    private String userBirthday ;
    private String userEmail ;
    private String userCurrent ;
    private String userUpdate ;
    private String userAddress ;
    private Integer userStatus ;
    private String userMobile ;
    private Integer isAdminLogin;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userCurrent='" + userCurrent + '\'' +
                ", userUpdate='" + userUpdate + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userMobile=" + userMobile +
                ", isAdminLogin=" + isAdminLogin +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCurrent() {
        return userCurrent;
    }

    public void setUserCurrent(String userCurrent) {
        this.userCurrent = userCurrent;
    }

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getIsAdminLogin() {
        return isAdminLogin;
    }

    public void setIsAdminLogin(Integer isAdminLogin) {
        this.isAdminLogin = isAdminLogin;
    }
}
