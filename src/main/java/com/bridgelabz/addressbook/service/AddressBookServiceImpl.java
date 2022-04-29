package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
     * @return list of AddressBook details from DB
     */
    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }

    /**
     * accepts the person id
     * @param personId
     * @return list of AddressBook details from DB
     */
    @Override
    public AddressBookData getAddressBookById(Long personId) {
        return addressBookRepository.findById(personId).orElseThrow(()->new AddressBookException("Person with this ID doesnt exists"));
    }

    /**
     * accepts the person details in the form
     * of AddressBookDTO and stores it in List
     * @param addressBookDTO
     * @return accepted addressBookData object
     */
    @Override
    public AddressBookData addNewContact(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    /**
     * accepts the person id and new person details in the form
     * of AddressBookDTO and stores it in List
     * @param personId
     * @param addressBookDTO
     * @return updated addressBookData object
     */
    @Override
    public AddressBookData updateContact(long personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookById(personId);
        addressBookData.updateContact(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    /**
     * deletes the data that matches the person id from DB
     * @param personId
     */
    @Override
    public void deleteContact(long personId) {
        AddressBookData addressBookData = this.getAddressBookById(personId);
        addressBookRepository.delete(addressBookData);

    }


}
