package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

import java.util.List;

public interface AddressBookService {

    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookById(int personId);

    AddressBookData addNewContact(AddressBookDTO addressBookDTO);

    AddressBookData updateContact();

    void deleteContact();
}
