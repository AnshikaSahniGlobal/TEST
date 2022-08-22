

package com.example.restful.controller;

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

import org.springframework.web.bind.annotation.RestController;

import com.example.restful.dao.CustomerRepo;
import com.example.restful.model.Customer;


@RestController

public class CustomerController

{

 @Autowired

 CustomerRepo repo;


 @PostMapping(path="/customer",consumes= {"application/json"})

 public Customer addCustomer(@RequestBody Customer customer)

 {

 repo.save(customer);

 return customer;

 }

 @GetMapping(path="/customers")

 public List<Customer> getCustomers()

 {

 return repo.findAll();

 }

 @RequestMapping("/customer/{customerid}")

 public Optional<Customer> getAlien(@PathVariable("customerid")int customerid)

 {

 return repo.findById(customerid);

 }

 @DeleteMapping("/customer/{customerid}")

 public String deleteAlien(@PathVariable int customerid)

 {

 Customer a = repo.getOne(customerid);

 repo.delete(a);

 return "deleted";

 }

 @PutMapping(path="/customer",consumes= {"application/json"})

 public Customer saveOrUpdateAlien(@RequestBody Customer customer)

 {

 repo.save(customer);

 return customer;

 }

}



