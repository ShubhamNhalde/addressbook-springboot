package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

import java.util.List;

public interface AddressBookService {

    String createAddressBookData(AddressBookDTO addressBookDTO);

    List<AddressBookData> getAddressBookDataByToken(String token);

    AddressBookData getRecordByToken(String token);

    AddressBookData updateRecordByToken(String token, AddressBookDTO addressBookDTO);

    AddressBookData deleteRecordByToken(String token);
}

