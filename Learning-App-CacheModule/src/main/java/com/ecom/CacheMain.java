package com.ecom;

import com.ecom.mongo.LoadData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.ecom.repo")
@ComponentScan({"com.ecom.pojo","com.ecom.repo"})


public class CacheMain implements CommandLineRunner {

@Autowired
LoadData loadData;
    public static void main(String[] args) {
        SpringApplication.run(CacheMain.class,args);


    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Output........");

       loadData.getDataFromMongoDb();

    }
}
