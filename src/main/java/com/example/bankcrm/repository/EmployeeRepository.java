package com.example.bankcrm.repository;

import com.example.bankcrm.entity.Branch;
import com.example.bankcrm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmail(String email);


    List<Employee> findAllByBranch(Branch branch);
}
