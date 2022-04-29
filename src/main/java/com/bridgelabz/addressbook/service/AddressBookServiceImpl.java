package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookById(Long personId) {
        return addressBookRepository.findById( personId).orElseThrow();
    }


    @Override
    public AddressBookData addNewContact(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }


    @Override
    public AddressBookData updateContact(long personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookById(personId);
        addressBookData.updateContact(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteContact(long personId) {
        AddressBookData addressBookData = this.getAddressBookById(personId);
        addressBookRepository.delete(addressBookData);

    }


}
