package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getAddressBookData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<String> getAddressBookData(@PathVariable int personId) {
        return new ResponseEntity<String>("Get Call Success for Id:" + personId, HttpStatus.OK);
    }

    @PostMapping("/addnewcontact")
    public ResponseEntity<String> addNewContact(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<String>("Added New Contact", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateContact(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<String>("Updated Contact:" + addressBookDTO, HttpStatus.OK);
    }
}
