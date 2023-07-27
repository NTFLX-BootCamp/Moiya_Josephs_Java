package com.company.customerdataservice.repository;


import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTests {


    @Autowired
    CustomerRepository customerRepo;


    @BeforeEach
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void addCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("M");
        customer.setLastName("J");
        customer.setPhone("712-999-1889");
        customer.setCompany("BigCo");
        customer.setAddress_1("123 Main St");
        customer.setAddress_2("Apt 6");
        customer.setCity("Bronx");
        customer.setPostalCode(15500);
        customer.setEmail("mj@email.com");
        customer.setState("NY");

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomer_id());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void getCustomerById() {
        //Arrange...

        Customer customer = new Customer();
        customer.setFirstName("M");
        customer.setLastName("J");
        customer.setPhone("712-999-1889");
        customer.setCompany("BigCo");
        customer.setAddress_1("123 Main St");
        customer.setAddress_2("Apt 6");
        customer.setCity("Bronx");
        customer.setPostalCode(15500);
        customer.setEmail("mj@email.com");
        customer.setState("NY");
        customer.setCustomer_id(1);

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomer_id());

        assertEquals(customer1.get(), customer);
    }


    @Test
    public void getCustomersByState() {
        //Arrange...

        Customer customer = new Customer();
        customer.setFirstName("M");
        customer.setLastName("J");
        customer.setPhone("712-999-1889");
        customer.setCompany("BigCo");
        customer.setAddress_1("123 Main St");
        customer.setAddress_2("Apt 6");
        customer.setCity("Bronx");
        customer.setPostalCode(15500);
        customer.setEmail("mj@email.com");
        customer.setState("NY");
        customer.setCustomer_id(1);

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        List<Customer> customer1 = customerRepo.findByState(customer.getState());

        assertEquals(1, customer1.size());
    }

    @Test
    public void updateCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("M");
        customer.setLastName("J");
        customer.setPhone("712-999-1889");
        customer.setCompany("BigCo");
        customer.setAddress_1("123 Main St");
        customer.setAddress_2("Apt 6");
        customer.setCity("Bronx");
        customer.setPostalCode(15500);
        customer.setEmail("mj@email.com");
        customer.setState("NY");
        customerRepo.save(customer);

        //Act...
        customer.setFirstName("UPDATED");

        customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomer_id());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void deleteCustomer() {
        //Arrange...

        Customer customer = new Customer();
        customer.setFirstName("M");
        customer.setLastName("J");
        customer.setPhone("712-999-1889");
        customer.setCompany("BigCo");
        customer.setAddress_1("123 Main St");
        customer.setAddress_2("Apt 6");
        customer.setCity("Bronx");
        customer.setPostalCode(15500);
        customer.setEmail("mj@email.com");
        customer.setState("NY");
        customerRepo.save(customer);

        //Act...
        customerRepo.deleteById(customer.getCustomer_id());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomer_id());
        assertFalse(customer1.isPresent());
    }
}


