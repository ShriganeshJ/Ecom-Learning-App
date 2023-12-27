package com.ecom.pojo;

import org.springframework.data.mongodb.core.mapping.Field;

public class UserInfo {

    private String userId;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", userAccountType='" + userAccountType + '\'' +
                ", brokerName='" + brokerName + '\'' +
                '}';
    }

    private String email;

    private String userAccountType;
    private String brokerName;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(String userAccountType) {
        this.userAccountType = userAccountType;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }


}
