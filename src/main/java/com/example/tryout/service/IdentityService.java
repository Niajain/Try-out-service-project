package com.example.tryout.service;

import com.example.tryout.model.Customer;
import com.example.tryout.model.Identity;
import com.example.tryout.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class IdentityService {

    private final CustomerService customerService;

    private final CustomerRepository customerRepository;

    public IdentityService(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    public void addIdentity(Identity identity, String email) {
        Customer customer=customerService.getCusterByEmail(email);
        customer.setIdentity(identity);

        customerRepository.save(customer);

    }
}
