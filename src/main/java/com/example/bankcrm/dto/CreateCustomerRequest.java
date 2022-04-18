package com.example.bankcrm.dto;

import com.example.bankcrm.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private String customer_class;
    private Document document;
    private Address address;
    private Product product;
    private Workplace workplace;
    private List<Integer> branches;
}
