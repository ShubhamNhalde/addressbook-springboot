package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import com.bridgelabz.addressbook.util.EmailSenderService;
import com.bridgelabz.addressbook.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private TokenUtil tokenutil;

    @Autowired
    EmailSenderService sender;


    public String createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData newContact = new AddressBookData(addressBookDTO);
        addressBookRepository.save(newContact);
        String token = tokenutil.createToken(newContact.getId());
        sender.sendEmail(newContact.getEmail(), "User Register", "User Registered Successfully, Hello "
                + newContact.getFirstName() + " " + newContact.getLastName() + " Please get your data here :: "
                + token);
        return token;
    }

    public AddressBookData updateRecordByToken(String token, AddressBookDTO addressBookDTO) {
        Integer id = tokenutil.decodeToken(token);
        Optional<AddressBookData> addressBook = addressBookRepository.findById(id);
        if (addressBook.isEmpty()) {
            throw new AddressBookException("AddressBook Details for id not found");
        }
        AddressBookData newData = new AddressBookData(id, addressBookDTO);
        addressBookRepository.save(newData);
        sender.sendEmail(newData.getEmail(), "Update Email", " Contact update successful, Hello :: "
                + newData.getFirstName() + " " + newData.getLastName() + " Your Contact Data Is Updated. \uD83D\uDE4C "
        );
        return newData;
    }

    public AddressBookData deleteRecordByToken(String token) {
        Integer id = tokenutil.decodeToken(token);
        Optional<AddressBookData> addressBook = addressBookRepository.findById(id);
        if (addressBook.isEmpty()) {
            log.warn("Unable to find address book details for given id: " + id);
            throw new AddressBookException("Address Book Details not found");
        } else {
            addressBookRepository.deleteById(id);
            sender.sendEmail("nhaldes@gmail.com", "Contact Deleted", " Contact Deleted Successfully,  "
                    + addressBook.get()
            );
        }
        throw new AddressBookException(" Token Deleted Successfully");
    }

    public List<AddressBookData> getAddressBookDataByToken(String token) {
        int id = tokenutil.decodeToken(token);
        Optional<AddressBookData> isContactPresent = addressBookRepository.findById(id);
        if (isContactPresent.isPresent()) {
            List<AddressBookData> listAddressBook = addressBookRepository.findAll();
            sender.sendEmail("nhaldes@gmail.com", "Test Email", " Get your data with this token, "
                    + isContactPresent.get().getFirstName() + " " + isContactPresent.get().getLastName() + " Please get your data here :: "
                    + "http://localhost:8080/addressbook/retrieve/" + token);
            return listAddressBook;
        } else {
            throw new AddressBookException("Exception Token Not found");
        }
    }

    public AddressBookData getRecordByToken(String token) {
        Integer id = tokenutil.decodeToken(token);
        Optional<AddressBookData> addressBook = addressBookRepository.findById(id);
        if (addressBook.isEmpty()) {
            log.warn("Unable to find address book details for given id: " + id);
            throw new AddressBookException("Address Book Details not found for that particular id");
        } else {
            sender.sendEmail(" nhaldes@gmail.com ", "Test Email", "Get data successfully, hii: "
                    + addressBook.get().getFirstName() + " " + addressBook.get().getLastName() + " Please check your data here :: "
                    + addressBook.get());

            return addressBook.get();
        }

    }

}
