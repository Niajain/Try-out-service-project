package com.example.tryout.controller;

import com.example.tryout.Enum.Gender;
import com.example.tryout.dto.request.CustomerRequest;
import com.example.tryout.dto.response.CustomerResponse;
import com.example.tryout.model.Customer;
import com.example.tryout.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @PostMapping("/addCustomer")
//    public Customer addCustomer(@RequestBody Customer customer){
//        return customerService.addCustomer(customer);
//    } //WITHOUT DTO


    //with dto
    @PostMapping("/addCustomer")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }

//    @GetMapping("/getCustomer/id/{id}")
//    public Customer getCustomer(@PathVariable("id") int customerId)
//    {
//        return customerService.getCustomer(customerId);
//    } //without dto

    //with dto

    @GetMapping("/getCustomer/id/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") int customerId)
    {

        CustomerResponse customerResponse= customerService.getCustomer(customerId);
        return new ResponseEntity(customerResponse, HttpStatus.FOUND);
    }

    @GetMapping("/get-all")
    public List<Customer> getALlCustomers()
    {
        return customerService.getAllCustomers();
    }

    @GetMapping("/get/email/{email}")
    public Customer getCustomerByEmail(@PathVariable("email") String email)
    {
         return customerService.getCusterByEmail(email);
    }

    @GetMapping("/get/age/{age}")
    public List<Customer> getCustomerByAge(@PathVariable("age") int age)
    {
        return customerService.getCustomerByAge(age);
    }

    //without dto
//    @GetMapping("/get-by-gender-age")
//    public List<Customer> getAllByGenderAndAge(@RequestParam("gender") Gender gender, @RequestParam("age") int age)
//    {
//        return customerService.getAllByGenderAndAge(gender,age);
//    }

    //with dto
    @GetMapping("/get-by-gender-age")
    public List<CustomerResponse> getAllByGenderAndAge(@RequestParam("gender") Gender gender, @RequestParam("age") int age)
    {
        return customerService.getAllByGenderAndAge(gender,age);
    }

    @GetMapping("/get-count")
    public int getCountOfAgeGreaterThan(@RequestParam("age") int age)
    {
        return customerService.getCountOfAgeGreaterThan(age);
    }

//    @GetMapping("/get-count-gender")
//    public int getCountOfGender(@RequestParam("gender") Gender gender)
//    {
//        return customerService.getCountOfGender(gender);
//    }
    //doing by HQL

    @GetMapping("/get-count-gender")
    public int getCountOfGender(@RequestParam("gender") String gender)
    {
        return customerService.getCountOfGender(gender);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestParam("email") String email)
    {
        customerService.deleteCustomer(email);
        return new ResponseEntity<>("Customer deleted",HttpStatus.ACCEPTED);
    }

}
