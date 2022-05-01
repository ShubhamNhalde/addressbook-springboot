package com.bridgelabz.addressbook2.model;

import com.bridgelabz.addressbook2.dto.AddressBookDTO;
import lombok.Data;

public @Data class AddressBookData {

    private int person_id;
    private String first_name;
    private String last_name;
    private String address;
    private String phone_no;
    private String city;
    private String state;
    private String zip_code;



    public AddressBookData(int i, AddressBookDTO addressBookDTO) {
        this.person_id = i;
        this.updateAddressBookData(addressBookDTO);
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO) {

        this.first_name = addressBookDTO.first_name;
        this.last_name = addressBookDTO.last_name;
        this.address = addressBookDTO.address;
        this.phone_no = addressBookDTO.phone_no;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zip_code = addressBookDTO.zip_code;

    }
}

