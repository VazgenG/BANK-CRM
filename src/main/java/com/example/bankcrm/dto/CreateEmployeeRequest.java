package com.example.bankcrm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String business_phone;
    private String user_name;
    private String password;
    private String position;
    private int branchId;
    private int documentId;

}
