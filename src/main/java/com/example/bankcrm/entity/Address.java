package com.example.bankcrm.entity;


import com.example.bankcrm.Enum.City;
import com.example.bankcrm.Enum.Region;
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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String home;

    @Enumerated(EnumType.STRING)
    private Region region;
    private City city;

}
