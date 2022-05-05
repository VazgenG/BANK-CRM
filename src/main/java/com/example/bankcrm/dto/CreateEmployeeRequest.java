package com.example.bankcrm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    @NotEmpty
    private int id;
    @NotBlank(message = "enter  your name")
    @NotEmpty
    private String name;
    @NotBlank(message = "enter  your surname")
    @NotEmpty
    private String surname;
    @NotBlank(message = "enter  your email")
    @NotEmpty
    private String email;
    @NotBlank(message = "enter  your phone")
    @NotEmpty
    private String business_phone;
    @NotBlank(message = "enter  your user name")
    @NotEmpty
    private String user_name;
    @NotBlank(message = "enter  your password")
    @NotEmpty
    private String password;
    @NotBlank(message = "enter  your position")
    @NotEmpty
    private String position;
    @NotBlank(message = "enter  your branch name")
    @NotEmpty
    private int branchId;
    @NotBlank(message = "enter  your document")
    @NotEmpty
    private int documentId;

}
