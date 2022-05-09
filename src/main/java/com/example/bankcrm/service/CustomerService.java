package com.example.bankcrm.service;

import com.example.bankcrm.entity.*;
import com.example.bankcrm.repository.BranchRepository;
import com.example.bankcrm.repository.CustomerRepository;
import com.example.bankcrm.repository.PassportRepository;
import com.example.bankcrm.repository.SocialCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final BranchRepository branchRepository;
    private final CustomerRepository customerRepository;
    private final PassportRepository passportRepository;
    private final SocialCardRepository socialCardRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();

    }

    public Customer addCustomer(Customer customer ) throws IOException {

        customerRepository.save(customer);
        return customer;
    }


    public Passport addPassport(@ModelAttribute Passport passport) {

        return passportRepository.save(passport);
    }

    public SocialCard addSocialCard(@ModelAttribute SocialCard socialCard) {

        return socialCardRepository.save(socialCard);

    }

    public Optional<Customer> findByToken(UUID token) {
        return customerRepository.findByToken(token);
    }
//    private List<Branch> getBranchesFromRequest(List<Integer> branchesIds) {
//        List<Branch> branches = new ArrayList<>();
//        for (Integer branch : branchesIds) {
//            branches.add(branchRepository.getById(branch));
//        }
//        return branches;
//    }

}
