package com.bridgelabz.addressbookspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookSpringApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book App");
        SpringApplication.run(AddressBookSpringApplication.class, args);
    }

}
