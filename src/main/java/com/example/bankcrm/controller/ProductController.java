package com.example.bankcrm.controller;

import com.example.bankcrm.entity.Product;
import com.example.bankcrm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    @GetMapping("/products")
    public  String productPage(ModelMap map){
        List<Product> products=productService.findAll();
        map.addAttribute("products",products);
        return "product";
    }
}
