package com.example.bankcrm.controller;

import com.example.bankcrm.security.CurrentUser;
import com.example.bankcrm.service.BranchService;
import com.example.bankcrm.service.CustomerService;
import com.example.bankcrm.entity.Customer;
import com.example.bankcrm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final ProductService productService;
    private final BranchService branchService;

    @GetMapping("/customers")
    public String customersPage(ModelMap map, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Customer> customers = customerService.findAll();
        map.addAttribute("customers", customers);
        map.addAttribute("currentUser", currentUser);
        //map.addAttribute("products", productService.findAll());
        //map.addAttribute("branches", branchService.findAll());
        return "customer";
    }

    @GetMapping("/addCustomer")
    public String addCustomerPage() {
        return "saveCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/addCustomer";
    }

}
