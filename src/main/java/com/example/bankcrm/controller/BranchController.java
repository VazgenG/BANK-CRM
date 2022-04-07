package com.example.bankcrm.controller;

import com.example.bankcrm.service.BranchService;
import com.example.bankcrm.entity.Branch;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequiredArgsConstructor
public class BranchController {
    private  final BranchService branchService;

    @GetMapping("/branches")
    public String customersPage(Model map, @AuthenticationPrincipal Branch branch) {

        map.addAttribute("branches", branchService.findAll());

        return "branches";
    }
}
