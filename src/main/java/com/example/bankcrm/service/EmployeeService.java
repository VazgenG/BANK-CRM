package com.example.bankcrm.service;

import com.example.bankcrm.entity.Branch;
import com.example.bankcrm.entity.Employee;
import com.example.bankcrm.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();

    }

    public List<Employee> findAllByBranch(Branch branch) {

        return employeeRepository.findAllByBranch(branch);


    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
