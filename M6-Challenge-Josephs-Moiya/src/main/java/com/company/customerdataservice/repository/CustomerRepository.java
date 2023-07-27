package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Create a new customer record. 5 pts

    //    Update an existing customer record. 5 pts

    //    Delete an existing customer record. 5 pts

    //    Find a customer record by id. 5 pts

    //    Find customer records by state. 5 pts
}
