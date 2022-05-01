package com.bridgelabz.addressbook2.service;

import com.bridgelabz.addressbook2.dto.AddressBookDTO;
import com.bridgelabz.addressbook2.model.AddressBookData;

import java.util.List;

public interface IAddressBookServices {

    List<AddressBookData> getEmployeePayrollData();

    AddressBookData getAddressBookDataById(int personId);

    AddressBookData createAddressBookData(AddressBookDTO AddressBookDTO);

    AddressBookData updateAddressBookData(int personId, AddressBookDTO AddressBookDTO);

    void deleteAddressBookData(int personId);
}
