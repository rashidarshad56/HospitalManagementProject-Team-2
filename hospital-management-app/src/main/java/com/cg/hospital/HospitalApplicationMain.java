package com.cg.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HospitalApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplicationMain.class, args);
        System.out.println("Application started!");
    }

}
