package com.example.bankcrm.repository;

import com.example.bankcrm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {



Optional<Customer> findByToken(UUID token);

}
