package com.example.bankcrm.controller;

import com.example.bankcrm.service.EmployeeService;
import com.example.bankcrm.entity.Branch;
import com.example.bankcrm.entity.Employee;

import com.example.bankcrm.service.BranchService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final BranchService branchService;


    @GetMapping("/employees")
    public String allEmployees(ModelMap map, @AuthenticationPrincipal Employee employee) {
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

    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employee employee) {

        employeeService.save(employee);
        return "redirect:/employees";
    }

}
