package com.example.bankcrm.controller;

import com.example.bankcrm.entity.Branch;
import com.example.bankcrm.service.BranchService;
import com.example.bankcrm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;


    private final ModelMapper mapper;
    private final CustomerService customerService;


    @GetMapping("/branch/add")
    public String addBranchPage(ModelMap map) {
        map.addAttribute("branches", branchService.findAll());
        map.addAttribute("customers", customerService.findAll());
        return "saveBranch";
    }


    @PostMapping("/branch/add")
    public String addBranch(@ModelAttribute Branch branch) {
        branchService.save(branch);
        return "redirect:/";
    }

}
