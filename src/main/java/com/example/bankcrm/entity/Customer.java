package com.example.bankcrm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private String customer_class;

    @ManyToOne(fetch = FetchType.EAGER)
    private Document document;
    @ManyToOne(fetch = FetchType.EAGER)
    private Address address;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    private Workplace workplace;

    @ManyToOne
    private Branch branch;

    private UUID token;

    private  boolean active;

    private LocalDateTime tokenCreatedDate;



}
