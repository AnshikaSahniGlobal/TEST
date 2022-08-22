package com.example.restful.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restful.model.Customer;


public interface CustomerRepo extends JpaRepository<Customer,Integer>

{

}


