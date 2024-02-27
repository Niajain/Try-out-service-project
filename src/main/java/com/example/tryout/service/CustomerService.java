package com.example.tryout.service;

import com.example.tryout.Enum.Gender;
import com.example.tryout.dto.request.CustomerRequest;
import com.example.tryout.dto.response.CustomerResponse;
import com.example.tryout.exception.CustomerNotFoundException;
import com.example.tryout.model.Customer;
import com.example.tryout.repository.CustomerRepository;
import com.example.tryout.service.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
//    public Customer addCustomer(Customer customer) {
//        return customerRepository.save(customer); //return saved customer
//    } //without dto

    //with request DTO to Entity
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        // Request DTo to entity
        Customer customer= CustomerTransformer.customerRequestToCustomer(customerRequest);

        Customer savedCustomer=customerRepository.save(customer); //return saved customer

        //saved entity to response dto
        return CustomerTransformer.customerToCustomerResponse(customer);
    }


//    public Customer getCustomer(int customerId) {
//        Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
//        if(optionalCustomer.isEmpty())
//        {
//            throw new CustomerNotFoundException("Invalid customer Id");
//        }
//        return optionalCustomer.get();
//    } //without dto

    //with dto
    public CustomerResponse getCustomer(int customerId) {
        Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Invalid customer Id");
        }
        Customer savedCustomer = optionalCustomer.get();

        //entity to Response DTo
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
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

    //without dto
//    public List<Customer> getAllByGenderAndAge(Gender gender, int age) {
//        return customerRepository.findByGenderAndAge(gender,age);
//    }

    //with dto
    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age) {
        List<Customer> customers= customerRepository.findByGenderAndAge(gender,age);

        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customers)
        {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
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

    public void deleteCustomer(String email) {
        Optional<Customer> optionalCustomer=customerRepository.findByEmailId(email);
        if(optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Customer doesn't exist");
        }
        customerRepository.delete(optionalCustomer.get());
    }
}
