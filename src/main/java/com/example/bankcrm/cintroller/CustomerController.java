package com.example.bankcrm.cintroller;

import com.example.bankcrm.Service.CustomerService;
import com.example.bankcrm.entity.Customer;
import com.example.bankcrm.entity.Passport;
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
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public String customersPage(Model map, @AuthenticationPrincipal Customer customer) {
        List<Customer> customers = customerService.findAll();
        map.addAttribute("customers", customer);
        return "customers";
    }


    @GetMapping("/addCustomer")
    public String addCustomerPage() {
        return "Custumers";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/saveCustomers";
    }

    @GetMapping("/addPassport")
    public  String addPassport(@ModelAttribute Passport passport){
        customerService.addPassport(passport);
        return "redirect:/savePassport";
    }

}
