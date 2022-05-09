package com.example.bankcrm.service;

import com.example.bankcrm.entity.Customer;
import com.example.bankcrm.entity.Product;
import com.example.bankcrm.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.print.attribute.standard.PrinterResolution;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();

    }

    public void addProduct(@ModelAttribute Product product){
        productRepository.save(product);
    }
}