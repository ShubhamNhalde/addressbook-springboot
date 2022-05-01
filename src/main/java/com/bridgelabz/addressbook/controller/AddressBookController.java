package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;


    @PostMapping(path = "/register")
    public ResponseEntity<ResponseDTO> addNewContact(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        String addressBookData = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Registered Successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/retrieve/{token}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable String token) {
        List<AddressBookData> listOfContacts = addressBookService.getAddressBookDataByToken(token);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:", listOfContacts);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @GetMapping("/get/{token}")
    public ResponseEntity<String> getRecordById(@PathVariable String token) throws AddressBookException {
        AddressBookData newAddressBook = addressBookService.getRecordByToken(token);
        ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully", newAddressBook);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @PutMapping("/update/{token}")
    public ResponseEntity<String> updateRecordById(@PathVariable String token, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.updateRecordByToken(token, addressBookDTO);
        ResponseDTO dto = new ResponseDTO("Updated addressBook data :", addressBookData);
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{token}")
    public ResponseEntity<String> deleteRecordById(@PathVariable String token) {
        ResponseDTO dto = new ResponseDTO("Deleted addressBook data with personId :", addressBookService.deleteRecordByToken(token));
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}
