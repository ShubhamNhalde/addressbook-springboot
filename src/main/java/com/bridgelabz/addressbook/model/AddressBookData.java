package com.bridgelabz.addressbook.model;


import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressBookData {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private long mobile_no;


    public AddressBookData(int id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipcode = addressBookDTO.zipcode;
        this.mobile_no = addressBookDTO.mobile_no;
    }
}
