package com.example.bankcrm.controller;

import com.example.bankcrm.dto.CreateCustomerRequest;
import com.example.bankcrm.entity.Employee;
import com.example.bankcrm.security.CurrentUser;
import com.example.bankcrm.service.BranchService;
import com.example.bankcrm.service.CustomerService;
import com.example.bankcrm.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    private final BranchService branchService;
    private final ModelMapper mapper;
    @GetMapping("/customers")
    public String customersPage(ModelMap map, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Customer> customers = customerService.findAll();
        map.addAttribute("currentUser", currentUser);
        map.addAttribute("customer", customerService.findAll());


        return "customer";
    }



    @GetMapping("/addCustomer")
    public String addCustomerPage(ModelMap map) {
        map.addAttribute("branches", branchService.findAll());
        return "saveCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute CreateCustomerRequest createCustomerRequest
    ) throws IOException {

        Customer customer = mapper.map(createCustomerRequest, Customer.class);

        customerService.addCustomer(customer,  createCustomerRequest.getBranches());
        return "redirect:/items";
    }
}
