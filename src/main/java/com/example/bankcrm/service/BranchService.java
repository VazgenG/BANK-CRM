package com.example.bankcrm.service;


import com.example.bankcrm.entity.Branch;
import com.example.bankcrm.entity.Customer;
import com.example.bankcrm.repository.BranchRepository;
import com.example.bankcrm.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private CustomerRepository customerRepository;

    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    public Branch findById(int id) {
        return branchRepository.getById(id);
    }

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }



}
