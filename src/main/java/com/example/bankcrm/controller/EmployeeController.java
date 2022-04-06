package com.example.bankcrm.controller;


import com.example.bankcrm.dto.CreateEmployeeRequest;
import com.example.bankcrm.entity.Branch;
import com.example.bankcrm.entity.Customer;
import com.example.bankcrm.entity.Employee;
import com.example.bankcrm.service.BranchService;
import com.example.bankcrm.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

private final EmployeeService employeeService;
    private final BranchService branchService;


    @GetMapping("/employees")
    public String employeesPage(ModelMap map) {
        List<Employee> employees = employeeService.findAll();
        map.addAttribute("employees", employees);

        return "employee";
    }

    @GetMapping("/employees/byBranch/{id}")
    public String employeesByBranchPage(ModelMap map, @PathVariable("id") int id) {
        Branch branch = branchService.findById(id);
        List<Employee> employees = employeeService.findAllByBranch(branch);
        map.addAttribute("employees", employees);

        return "employees";
    }

    @GetMapping("/employee/add")
    public String addEmployeePage() {
        return "saveEmployee";
    }

    @PostMapping("/employee/add")
    public String addCompany(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/saveEmployee";
    }

    @GetMapping("/employees/{id}")
    public String singleEmployee(@PathVariable int id, ModelMap map) {
        map.addAttribute("employee", employeeService.findById(id));
        return "singleEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteById(id);
        return "redirect:/";
    }


}
