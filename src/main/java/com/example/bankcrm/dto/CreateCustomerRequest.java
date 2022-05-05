package com.example.bankcrm.dto;

import com.example.bankcrm.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    @NotEmpty
    @NotBlank(message = "enter  name")
    private String name;
    @NotBlank(message = "enter  surname")
    @NotEmpty
    private String surname;
    @NotBlank(message = "enter  email")
    @NotEmpty
    private String email;
    @NotBlank(message = "enter  phone number")
    @NotEmpty
    private String phone_number;
    @NotBlank(message = "Choose  class ")
    @NotEmpty
    private String customer_class;
    @NotBlank(message = "Choose  document ")
    @NotEmpty
    private Document document;
    @NotBlank(message = "enter  address ")
    @NotEmpty
    private Address address;
    @NotBlank(message = "Choose  product ")
    @NotEmpty
    private Product product;
    @NotBlank(message = "Choose  workplace ")
    @NotEmpty
    private Workplace workplace;
    @NotBlank(message = "Choose  branch ")
    @NotEmpty
    private List<Integer> branches;


}
