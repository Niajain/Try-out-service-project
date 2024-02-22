package com.example.tryout.service;

import com.example.tryout.Enum.Gender;
import com.example.tryout.exception.CustomerNotFoundException;
import com.example.tryout.model.Customer;
import com.example.tryout.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer); //return saved customer
    }

    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Invalid customer Id");
        }
        return optionalCustomer.get();
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCusterByEmail(String email) {
        Optional<Customer> optionalCustomer=customerRepository.findByEmailId(email);
        if(optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Invalid Email Id");
        }
        return optionalCustomer.get();
    }

    public List<Customer> getCustomerByAge(int age) {
        return customerRepository.findByAge(age);
    }

    public List<Customer> getAllByGenderAndAge(Gender gender, int age) {
        return customerRepository.findByGenderAndAge(gender,age);
    }

    public int getCountOfAgeGreaterThan(int age) {
        return customerRepository.getCountOfAgeGreaterThan(age);
    }

//    public int getCountOfGender(Gender gender) {
//        return customerRepository.getCountOfGender(gender);
//    }
    //by HQL

    public int getCountOfGender(String gender) {
        return customerRepository.getCountOfGender(gender);
    }
}
