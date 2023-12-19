package com.ecom.pojo;

import org.springframework.data.mongodb.core.mapping.Field;

public class UserInfo {
    @Field("userID")
    private String userId;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", isUdc=" + isUdc +
                ", minTener='" + minTener + '\'' +
                ", maxTener='" + maxTener + '\'' +
                '}';
    }

    @Field("email")
    private String email;
    @Field("havingUDC")
    private  boolean isUdc;
    @Field("minTener")
    private String minTener;
    @Field("maxTener")
    private String maxTener;

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

    public boolean isUdc() {
        return isUdc;
    }

    public void setUdc(boolean udc) {
        isUdc = udc;
    }

    public String getMinTener() {
        return minTener;
    }

    public void setMinTener(String minTener) {
        this.minTener = minTener;
    }

    public String getMaxTener() {
        return maxTener;
    }

    public void setMaxTener(String maxTener) {
        this.maxTener = maxTener;
    }



}
