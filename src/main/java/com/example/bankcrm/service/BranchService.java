package com.example.bankcrm.service;

import com.example.bankcrm.entity.Branch;
import com.example.bankcrm.entity.Customer;
import com.example.bankcrm.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;


    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    public Branch findById(int id) {
        return branchRepository.getById(id);
    }
}