package org.example;

import com.len.util.LearingDAO;
import com.len.util.LeariningUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {

     List<LearingDAO> list=    LeariningUtil.getLearingDetails();
        System.out.println("First Deployment Success ! ");
        list.forEach(learingDAO -> System.out.println("User & User Id is "+learingDAO.getUser()+" "+learingDAO.getId()));


    }
}