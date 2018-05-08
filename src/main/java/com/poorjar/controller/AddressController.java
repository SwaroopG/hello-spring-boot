package com.poorjar.controller;

import com.poorjar.entity.Address;
import com.poorjar.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping("/addresses")
    public List<Address> handleRequest() {
        return this.addressRepository.findAll();
    }
}

