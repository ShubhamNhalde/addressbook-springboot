package com.bridgelabz.addressbook2.service;


import com.bridgelabz.addressbook2.dto.AddressBookDTO;
import com.bridgelabz.addressbook2.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServices implements IAddressBookServices {

    List<AddressBookData> addressbookDataList = new ArrayList();

    @Override
    public List<AddressBookData> getEmployeePayrollData() {
        return addressbookDataList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressbookDataList.get(personId - 1);
    }


    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressbookDataList.size() + 1, addressBookDTO);
        addressbookDataList.add(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO AddressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId - 1);
        addressBookData.updateAddressBookData(AddressBookDTO);
        return addressBookData;
    }

    @Override
    public void deleteAddressBookData(int personId) {
        addressbookDataList.remove(personId - 1);
    }
}

