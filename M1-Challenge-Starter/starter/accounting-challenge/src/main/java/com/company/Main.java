package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Update this

        List<Customer> customer = new ArrayList<>();
        // loop through customer data, in each string array, use the set functions to make the single customer
        // Check in customer data if the customer exists already.
        for (int i = 0; i < customerData.size(); i++) {
            int id = Integer.parseInt(customerData.get(i)[0]); // Get the ID
            String name = customerData.get(i)[1]; // Get the name

            Customer c = new Customer(id, name);

            if(!customer.contains(c)){
                customer.add(c);
            }
        }

        for (int i = 0; i < customerData.size(); i++) {
            int id = Integer.parseInt(customerData.get(i)[0]); // Get the ID
            //int charge = Integer.parseInt(customerData.get(i)[2]);
            int charge = Integer.valueOf(customerData.get(i)[2]);
            String chargeDate = customerData.get(i)[3];

            AccountRecord a = new AccountRecord();
            a.setCharge(charge);
            a.setChargeDate(chargeDate);

            //Source: https://stackoverflow.com/q/895257
            //add it to the values in customer List based on id
            for (Customer c : customer){
                if(c.getId() == id){
                    c.getCharges().add(a);
                }
            }
        }


        System.out.println(customer);
        // customer.getBalance() => check the balance
        String positive = "", negative = "";
        for (Customer c : customer){
            if(c.getBalance() > 0){
                 positive += " " + c.getName();
            }
            else {
                 negative += " " + c.getName();
            }
        }
        System.out.println("Positive accounts:" + positive );
        System.out.println("Negative accounts:" + negative);
    }
}
