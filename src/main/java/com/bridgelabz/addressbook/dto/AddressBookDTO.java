package com.bridgelabz.addressbook2.dto;

import lombok.Data;

public @Data class AddressBookDTO {
    public String first_name;

    public String last_name;

    public String address;

    public String phone_no;

    public String city;

    public String state;

    public String zip_code;

    @Override
    public String toString() {
        return "AddressBookDTO [first_name=" + first_name + ", last_name=" + last_name + ", address=" + address
                + ", phone_no=" + phone_no + ", city=" + city + ", state=" + state + ", zip_code=" + zip_code + "]";
    }
}
