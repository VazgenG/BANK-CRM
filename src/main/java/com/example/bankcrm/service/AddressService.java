package com.example.bankcrm.service;

import com.example.bankcrm.entity.Address;
import com.example.bankcrm.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


    @Service
    @RequiredArgsConstructor
    public class AddressService {
        private final AddressRepository addressRepository;

        public void addAddress(@ModelAttribute Address address) {
            addressRepository.save(address);
        }
    }

