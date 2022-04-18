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

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final BranchRepository branchRepository;
   private final CustomerRepository customerRepository;
   private  final PassportRepository passportRepository;
   private  final SocialCardRepository socialCardRepository;

   public List<Customer> findAll(){
       return customerRepository.findAll();

   }

    public Customer addCustomer(Customer customer,  List<Integer> branches) throws IOException {
        List<Branch> branchesFromDB = getBranchesFromRequest(branches);
//        customer.setEmployee(employee);
        customer.setBranches(branchesFromDB);
        customerRepository.save(customer);
        return customer;
    }


   public Passport addPassport(@ModelAttribute Passport passport){

       return passportRepository.save(passport);
   }

    public SocialCard addSocialCard(@ModelAttribute SocialCard socialCard) {

        return socialCardRepository.save(socialCard);
    }
    private List<Branch> getBranchesFromRequest(List<Integer> branchesIds) {
        List<Branch> branches = new ArrayList<>();
        for (Integer branch : branchesIds) {
            branches.add(branchRepository.getById(branch));
        }
        return branches;
    }

}
