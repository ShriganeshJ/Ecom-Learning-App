package org.core.java.builder;

import org.ecom.pojo.SuperLevelEntitlement;
import org.ecom.pojo.UserLevelEntitlment;

public class BuilderClassTest {


    public StaticDataContractService getAllEntitlement() {
        UserLevelEntitlment userLevelEntitlment = new UserLevelEntitlment();
        userLevelEntitlment.setId(12300);
        userLevelEntitlment.setName("userLevelEntitle");
        SuperLevelEntitlement superLevelEntitlement = new SuperLevelEntitlement();
        superLevelEntitlement.setId(458701);
        superLevelEntitlement.setName("superLevelEntitle");

        // return builder
        return StaticDataContractService.newBuilder()
                .setCategory("anc")
                .setPrice(4521)
                .setCategory("test")
                .setName("entitlement")
                .setUserLevelEntitlment(userLevelEntitlment)
                .setSuperLevelEntitlement(superLevelEntitlement)
                .build();

    }


    public static void main(String[] args) {
        BuilderClassTest builderClassTest = new BuilderClassTest();

        StaticDataContractService staticDataContractService = builderClassTest.getAllEntitlement();

       System.out.println("Product name:- "+staticDataContractService.getName());
        System.out.println("Category:- "+staticDataContractService.getCategory());
        System.out.println("Product Price:- "+staticDataContractService.getPrice());
        System.out.println("User Level Entitlment:- "+staticDataContractService.getUserLevelEntitlment());
        System.out.println("Super Level Entitlement:- "+staticDataContractService.getSuperLevelEntitlement());


    }
}
