package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)

public class CustomerControllerTests {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
    private List<Customer> customerList;

    @MockBean
    private CustomerRepository customerRepository;

    // Testing GET /customers/
    @Test
    public void shouldReturnNewCustomerOnPostRequest() throws Exception {
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

        String inputJson = mapper.writeValueAsString(customer);
        Customer customer2 = new Customer();
        customer2.setFirstName("M");
        customer2.setLastName("J");
        customer2.setPhone("712-999-1889");
        customer2.setCompany("BigCo");
        customer2.setAddress_1("123 Main St");
        customer2.setAddress_2("Apt 6");
        customer2.setCity("Bronx");
        customer2.setPostalCode(15500);
        customer2.setEmail("mj@email.com");
        customer2.setState("NY");
        customer2.setCustomer_id(2);

        String outputJson = mapper.writeValueAsString(customer2);


        mockMvc.perform(post("/customers").content(inputJson).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
    }


    // Testing PUT /customer/id
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {

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

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(
                        put("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    // Test DELETE /customer/{id}
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/customers/1")).andDo(print()).andExpect(status().isNoContent());
    }

    // Testing GET /customer/{id}
    @Test
    public void shouldReturnCustomerById() throws Exception {
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
        customer.setCustomer_id(3);


        mockMvc.perform(get("/customers/2"))
                .andDo(print())
                .andExpect(status().isOk());}

    // Testing GET /customer/{state}
    @Test
    public void shouldGetListofCustomersByState() throws Exception {
        String outputJson = mapper.writeValueAsString(customerList);

        mockMvc.perform(get("/customers/state/NY")).andDo(print()).andExpect(status().isOk());
    }


}
