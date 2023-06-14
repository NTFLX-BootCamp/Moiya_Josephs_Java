package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    Customer(){

    }

    Customer(int id, String name){
        this.id = id;
        this.name =name;
    }

    // Create constructor for easy obj init for testing
    Customer(int id, String name, List<AccountRecord> charges){
        this.id = id;
        this.name =name;
        this.charges = charges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        // set a balance variable
        int balance;
        // Use stream and the mapToInt to sum up the integers of the List charges
        balance = charges.stream().mapToInt(i -> i.getCharge()).sum();
        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    // Shouldn't there be a set charges?

    // Override the equals function so that it does not refer to the reference of the object, but the content of the object
    // Source: https://stackoverflow.com/a/16273399
    @Override
    public boolean equals(Object c) {
        boolean isEqual =false;
        if(c != null && c instanceof Customer){
            isEqual = (this.id == ((Customer)c).id);
        }
        return isEqual;
    }


    @Override
    public String toString() {
        //update this
        return "ID:"+ id + " Name:" + name + " Balance:" + getBalance() ;
    }
}
