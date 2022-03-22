package com.example.bankcrm.Service;

import com.example.bankcrm.entity.Customer;
import com.example.bankcrm.entity.Passport;
import com.example.bankcrm.repository.CustomerRepository;
import com.example.bankcrm.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

   private final CustomerRepository customerRepository;
   private  final PassportRepository passportRepository;

   public List<Customer> findAll(){
       return customerRepository.findAll();

   }
   public  void addCustomer(@ModelAttribute Customer customer){
       customerRepository.save(customer);
   }
   public Passport addPassport(@ModelAttribute Passport passport){

       return passportRepository.save(passport);
   }

}