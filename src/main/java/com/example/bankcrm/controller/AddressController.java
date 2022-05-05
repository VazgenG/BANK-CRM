package com.example.bankcrm.controller;

import com.example.bankcrm.entity.Address;
import com.example.bankcrm.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


    @Controller
    @RequiredArgsConstructor
    public class AddressController {
        private  final AddressService addressService;
        @GetMapping("/addAddress")
        public String addAddressPage() {
            return "saveAddress";
        }

        @PostMapping("/addAddress")
        public String addAddress(@ModelAttribute Address address) {
            addressService.addAddress(address);
            return "redirect:/addAddress";
        }



    }

