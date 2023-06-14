package com.company;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;


public class CustomerTest {

    //Initialize global variables needed for tests
    Customer customer;

    List<AccountRecord> account;
    AccountRecord charge;

    //Set up the objects needed before each test
    @BeforeEach
    public void setUp() {
        account = new ArrayList<>();
        charge = new AccountRecord();

        charge.setCharge(123);
        account.add(charge);

        customer = new Customer(1, "Wayne",account);
    }

    //Should return the balance of the account, 123
    @Test
    public void shouldGetBalance(){
        assertEquals(123, customer.getBalance());
    }

    // Sould display customer id, name and balance
    @Test
    public void shouldDisplayCustomerIDNameBalance(){
        assertEquals("1 Wayne 123", customer.toString());
    }


}