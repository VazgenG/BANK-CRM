package com.example.bankcrm.service;

import com.example.bankcrm.Enum.Position;
import com.example.bankcrm.dto.CreateEmployeeRequest;
import com.example.bankcrm.entity.Branch;
import com.example.bankcrm.entity.Employee;
import com.example.bankcrm.repository.BranchRepository;
import com.example.bankcrm.repository.DocumentRepository;
import com.example.bankcrm.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;
    private final BranchRepository branchRepository;
    private final DocumentRepository documentRepository;


    public Employee addEmployeeFromEmployeeRequest(CreateEmployeeRequest createEmployeeRequest, MultipartFile[] uploadedFiles) throws IOException {
        Employee employee = getEmployeeFromRequest(createEmployeeRequest);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee save(Employee employee) {
        String encode = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encode);
        employee.setPosition(Position.HRSpecialist);
        return employeeRepository.save(employee);
    }


    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee findById(int id) {
        return employeeRepository.getById(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findAllByBranch(Branch branch) {
        return employeeRepository.findAllByBranch(branch);
    }



    private Employee getEmployeeFromRequest(CreateEmployeeRequest createEmployeeRequest) {
        return Employee.builder()
                .id(createEmployeeRequest.getId())
                .name(createEmployeeRequest.getName())
                .surname(createEmployeeRequest.getSurname())
                .email(createEmployeeRequest.getEmail())
                .business_phone(createEmployeeRequest.getBusiness_phone())
                .user_name(createEmployeeRequest.getUser_name())
                .password(createEmployeeRequest.getPassword())

                .branch(branchRepository.findById(createEmployeeRequest.getBranchId()).orElse(null))
                .document(documentRepository.findById(createEmployeeRequest.getDocumentId()).orElse(null))
                .build();
    }
}
