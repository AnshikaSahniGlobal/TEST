package com.payment.service;
import java.util.Date;  

import java.util.Random;

import com.payment.model.Payment;

public class PaymentServiceImplementation implements PaymentService {



 public String getPaymentDescription() {

 Payment existingPayment = new Payment();

 existingPayment.setPaymentDescription("Payment for 1234 in units");

 return "Description: " + existingPayment.getPaymentDescription();

 }



 public String getPaymentCode() {

 Payment existingPayment = new Payment();

 existingPayment.setPaymentCode("1234");

 return "Payment Code: " + existingPayment.getPaymentCode();

 }

	

 public Payment createPayment(Payment payment) {

 Payment newPayment = new Payment();

 newPayment.setPaymentId(new Random().nextInt());

 newPayment.setPaymentCode("1234");

 newPayment.setPaymentStatus("INITIATED");

 newPayment.setPaymentDate(new Date());

 return newPayment;

 }

	

 public Payment getPayment(int id) {

 Payment newPayment = new Payment();

 newPayment.setPaymentId(new Random().nextInt());

 newPayment.setPaymentCode("1234");

 newPayment.setPaymentStatus("COMPLETED");

 newPayment.setPaymentDate(new Date());

 newPayment.setPaymentDescription("This is the new 1234 payment");

 return newPayment;

 }

}