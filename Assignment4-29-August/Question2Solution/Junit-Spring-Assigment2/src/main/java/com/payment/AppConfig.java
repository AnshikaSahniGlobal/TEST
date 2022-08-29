package com.payment;
import org.springframework.context.annotation.Bean;   

import org.springframework.context.annotation.Configuration;

import com.payment.service.PaymentService;
import com.payment.service.PaymentServiceImplementation;

@Configuration

public class AppConfig {

 @Bean

 public PaymentService getPaymentService() {

 return new PaymentServiceImplementation();

 }

}
