package com.company.customerdataservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_id;
    private String firstName;

    private String lastName;

    private String email;

    private String company;

    private String phone;

    private String address_1;

    private String address_2;

    private String city;

    private String state;

    private int postalCode;

    private String country;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customer_id == customer.customer_id && postalCode == customer.postalCode && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(company, customer.company) && Objects.equals(phone, customer.phone) && Objects.equals(address_1, customer.address_1) && Objects.equals(address_2, customer.address_2) && Objects.equals(city, customer.city) && Objects.equals(state, customer.state) && Objects.equals(country, customer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, firstName, lastName, email, company, phone, address_1, address_2, city, state, postalCode, country);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", address_1='" + address_1 + '\'' +
                ", address_2='" + address_2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                '}';
    }
}
