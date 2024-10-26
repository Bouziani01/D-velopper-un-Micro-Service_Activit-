package com.example.bank_account_service.Repositories;

import com.example.bank_account_service.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
