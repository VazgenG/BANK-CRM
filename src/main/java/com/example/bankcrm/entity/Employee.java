package com.example.bankcrm.entity;

import com.example.bankcrm.Enum.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String business_phone;
    private String user_name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne(fetch = FetchType.EAGER)
    Branch branch;
    @ManyToOne(fetch = FetchType.EAGER)
    Document document;
}
