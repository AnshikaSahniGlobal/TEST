package com.example.demo.controller;
import java.util.List;  


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;


@RestController

public class CustomerController

{

 @Autowired

 CustomerRepo repo;


 @PostMapping

 public Customer addCustomer(@RequestBody Customer customer)

 {

    return repo.save(customer);



 }

 @GetMapping("/customers/{id}")

 public Optional<Customer> getCustomers(@PathVariable("id")int id)

 {
        Optional<Customer> cust=repo.findById(id);
        return cust;

 }

 @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")

 public List<Customer> getCustomer()

 {

    return repo.findAll();

 }

 @DeleteMapping("/customers/{id}")

 public void deleteCustomer(@PathVariable int id)

 {

    repo.deleteById(id);

 

 }

 @PutMapping("/customers/{id}")

 public Customer saveOrUpdateCustomer(@PathVariable int id,@RequestBody Customer customer)

 {
	 Optional<Customer>cust= repo.findById(id);
      return repo.save(customer);



 }

}

