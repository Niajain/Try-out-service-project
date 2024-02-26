package com.example.tryout.service.transformer;

import com.example.tryout.dto.request.CustomerRequest;
import com.example.tryout.dto.response.CustomerResponse;
import com.example.tryout.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest)
    {
//        Customer customer=new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setEmailId(customerRequest.getEmailId());
//        customer.setAge(customerRequest.getAge());
//        customer.setGender(customerRequest.getGender());
//        customer.setCity(customerRequest.getCity());
        //without using Builder (as builder is annotation through which we can easily set the values
//        return customer;

        //through builder
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .city(customerRequest.getCity())
                .build();


    }

    public static CustomerResponse customerToCustomerResponse(Customer savedCustomer)
    {
//        CustomerResponse customerResponse=new CustomerResponse();
//        customerResponse.setName(savedCustomer.getName());
//        customerResponse.setEmailId(savedCustomer.getEmailId());
//        customerResponse.setCreated(savedCustomer.getCreated());
//
//        return customerResponse;
        //without builder


        //through builder
        return CustomerResponse.builder()
                .name(savedCustomer.getName())
                .emailId(savedCustomer.getEmailId())
                .created(savedCustomer.getCreated())
                .build();
    }
}
