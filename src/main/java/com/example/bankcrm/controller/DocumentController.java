package com.example.bankcrm.controller;

import com.example.bankcrm.service.CustomerService;
import com.example.bankcrm.entity.Customer;
import com.example.bankcrm.entity.Passport;
import com.example.bankcrm.entity.SocialCard;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DocumentController {
    private final CustomerService customerService;

    @GetMapping("/documents")
    public String customersPage(Model map, @AuthenticationPrincipal Customer customer) {
        List<Customer> customers = customerService.findAll();
        map.addAttribute("documents", customer);
        return "document";
    }


    @GetMapping("/addPassport")
    public String addCustomerPage() {
        return "savePassport";
    }


    @PostMapping("/addPassport")
    public  String addPassport(@ModelAttribute Passport passport){
        customerService.addPassport(passport);
        return "redirect:/savePassport";
    }

    @GetMapping("/addSocialCard")
    public String addSocialCardPage() {
        return "saveSocialCard";
    }


    @PostMapping("/socialCard/add")
    public  String addSocialCard(@ModelAttribute SocialCard socialCard){
        customerService.addSocialCard(socialCard);
        return "redirect:/addCustomer";
    }

}
