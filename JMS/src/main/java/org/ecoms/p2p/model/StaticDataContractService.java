package org.ecoms.p2p.model;


public class StaticDataContractService {
    private String k1Number;
    private EntitlementData entitlementData;
    private UserInfo userInfo;

    // Private constructor to enforce the use of the builder
    private StaticDataContractService(Builder builder) {

        this.k1Number = builder.k1Number;
        this.entitlementData = builder.entitlementData;
        this.userInfo = builder.userInfo;
    }

    // Getter methods


    public String getK1Number() {
        return k1Number;
    }

    public EntitlementData getlEntitlment() {
        return entitlementData;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    // Builder class for Product
    public static class Builder {

        private String k1Number;
        private EntitlementData entitlementData;
        private UserInfo userInfo;
        // Setter methods for each parameter


        public Builder setK1Number(String k1Number) {
            this.k1Number = k1Number;
            return this;
        }

        public Builder setEntitlment(EntitlementData entitlementData) {
            this.entitlementData = entitlementData;
            return this;
        }

        public Builder setUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
            return this;
        }


        // Build method to create the Product instance
        public StaticDataContractService build() {
            // Validate parameters if needed
            // For simplicity, let's assume all parameters are mandatory

            return new StaticDataContractService(this);
        }
    }

    // Factory method to create a new builder
    public static Builder newBuilder() {
        return new Builder();
    }

}








