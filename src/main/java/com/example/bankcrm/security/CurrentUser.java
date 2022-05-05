package com.example.bankcrm.security;

import com.example.bankcrm.entity.Employee;

import org.springframework.security.core.authority.AuthorityUtils;


public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Employee employee;

    public CurrentUser(Employee employee) {
        super(employee.getEmail(), employee.getPassword(),
                AuthorityUtils.createAuthorityList(employee.getPosition().name()));


        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
