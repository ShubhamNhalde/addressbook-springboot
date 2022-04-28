package com.bridgelabz.addressbook.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class AddressBookDTO {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zipcode;
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
