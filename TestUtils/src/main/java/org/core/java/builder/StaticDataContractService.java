package org.core.java.builder;


import org.ecom.pojo.SuperLevelEntitlement;
import org.ecom.pojo.UserLevelEntitlment;

public class StaticDataContractService {
        private final String name;
        private final int price;
        private  String category;
        private UserLevelEntitlment userLevelEntitlment;
        private SuperLevelEntitlement  superLevelEntitlement;

        // Private constructor to enforce the use of the builder
        private StaticDataContractService(Builder builder) {
            this.name = builder.name;
            this.price = builder.price;
            this.category = builder.category;
            this.userLevelEntitlment= builder.userLevelEntitlment;
            this.superLevelEntitlement=builder.superLevelEntitlement;
        }

        // Getter methods

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public String getCategory() {
            return category;
        }

    public UserLevelEntitlment getUserLevelEntitlment() {
        return userLevelEntitlment;
    }

    public SuperLevelEntitlement getSuperLevelEntitlement() {
        return superLevelEntitlement;
    }

        // Builder class for Product
        public static class Builder {
            private String name;
            private int price;
            private String category;
            private UserLevelEntitlment userLevelEntitlment;
            private SuperLevelEntitlement  superLevelEntitlement;
            // Setter methods for each parameter

            public Builder setName(String name) {
                this.name = name;
                return this;
            }

            public Builder setPrice(int price) {
                this.price = price;
                return this;
            }

            public Builder setCategory(String category) {
                this.category = category;
                return this;
            }
            public Builder setUserLevelEntitlment(UserLevelEntitlment userLevelEntitlment) {
                this.userLevelEntitlment = userLevelEntitlment;
                return this;
            }

            public Builder setSuperLevelEntitlement(SuperLevelEntitlement superLevelEntitlement) {
                this.superLevelEntitlement = superLevelEntitlement;
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








