package com.bridgelabz.addressbook.dto;


import lombok.Data;

import javax.validation.constraints.Pattern;

public @Data class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee firstName Invalid")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee lastName Invalid")
    public String lastName;
    public String address;
    public String email;
    public String city;
    public String state;

    @Pattern(regexp = "^[0-9]{6}$", message = "Invalid Zip Number.Try Again")
    public String zipcode;

    //@Pattern(regexp = "^[0-9]{10}$", message = "Phone Number is Invalid")
    public long mobile_no;

    public AddressBookDTO(String firstName, String lastName, String address, String city, String state, String zipcode, long mobile_no) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.mobile_no = mobile_no;
    }

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", mobile_no=" + mobile_no +
                '}';
    }
}
