package com.company;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;


public class CustomerTest {

    Customer customer;

    List<AccountRecord> account;
    AccountRecord charge;

    @BeforeEach
    public void setUp() {
        account = new ArrayList<>();
        charge = new AccountRecord();

        charge.setCharge(123);
        account.add(charge);

        customer = new Customer(1, "Wayne",account);
    }

    @Test
    public void shouldGetBalance(){
        assertEquals(123, customer.getBalance());
    }

    @Test
    public void shouldDisplayCustomerIDNameBalance(){
        assertEquals("1 Wayne 123", customer.toString());
    }


}