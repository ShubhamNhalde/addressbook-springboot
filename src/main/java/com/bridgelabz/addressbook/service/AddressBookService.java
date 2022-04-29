package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

import java.util.List;

public interface AddressBookService {

    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookById(Long personId);

    AddressBookData addNewContact(AddressBookDTO addressBookDTO);

    void deleteContact(long personId);

    AddressBookData updateContact(long personId, AddressBookDTO addressBookDTO);
}
