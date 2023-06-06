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
        // sum up the charges in charges list
        int balance =  0;
        for(AccountRecord charge : charges) {
            balance+= charge.getCharge();
        }
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
        return id + " " + name + " " + getBalance() ;
    }
}