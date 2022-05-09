package com.example.bankcrm.controller;

import com.example.bankcrm.dto.CreateCustomerRequest;
import com.example.bankcrm.entity.Branch;
import com.example.bankcrm.entity.Employee;
import com.example.bankcrm.security.CurrentUser;
import com.example.bankcrm.service.BranchService;
import com.example.bankcrm.service.CustomerService;
import com.example.bankcrm.entity.Customer;
import com.example.bankcrm.service.MailService;
import com.example.bankcrm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.IToken;
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

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final ProductService productService;
    private final BranchService branchService;
    private final ModelMapper mapper;
    private final MailService mailService;

    @GetMapping("/customers")
    public String customersPage(ModelMap map, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Customer> customers = customerService.findAll();
        map.addAttribute("customers", customers);
        map.addAttribute("currentUser", currentUser);
        //   map.addAttribute("products", productService.findAll());
        map.addAttribute("branches", branchService.findAll());
        return "customer";
    }


    @GetMapping("/Customer/add")
    public String addCustomerPage(ModelMap map, @AuthenticationPrincipal CreateCustomerRequest createCustomerRequest) {
        map.addAttribute("branches", branchService.findAll());
        map.addAttribute("currentUser", createCustomerRequest);
        return "saveCustomer";
    }

    @PostMapping("/Customer/add")
    public String addCustomer(@ModelAttribute @Valid CreateCustomerRequest createCustomerRequest) throws IOException {

        Customer customer = mapper.map(createCustomerRequest, Customer.class);
        customer.setActive(false);
        customer.setToken(String.valueOf(UUID.randomUUID()));
        customer.setTokenCreatedDate(LocalDateTime.now());
        customerService.addCustomer(customer);
        mailService.sendMail(customer.getEmail(), "Welcome  " + customer.getSurname(),

                "your have register " + customer.getName() +
                        "for activation please click on this url : http://localhost:8080/customer/activate?token ="
                        + customer.getToken());
        return "redirect:/customers";
    }

    @GetMapping("/customer/activate")
    public String activateCustomer(ModelMap map, @RequestParam String token) throws IOException {
        Optional<Customer> customer = customerService.findByToken(UUID.fromString(token));if (!customer.isPresent()) {
            map.addAttribute("message", "Customer Does not exists");
            return "activateCustomer";

        }
        Customer customerFromDb = customer.get();
        if (customerFromDb.isActive()) {
            map.addAttribute("messagae", "customer already active ");
            return "activateCustomer";
        }
        customerFromDb.setActive(true);
        customerFromDb.setToken(null);
        customerFromDb.setTokenCreatedDate(null);
        try {
            customerService.addCustomer(customerFromDb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        map.addAttribute("message", "Customer activated ");
        return "activateCustomer";

    }
}


