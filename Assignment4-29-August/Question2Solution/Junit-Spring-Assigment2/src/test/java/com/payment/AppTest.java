package com.payment;

import org.junit.After;   

import org.junit.AfterClass;

import org.junit.Before;

import org.junit.BeforeClass;

import org.junit.Test;

import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.BaseMatcher.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.payment.AppConfig;
import com.payment.model.Payment;
import com.payment.service.PaymentService;
 

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes=AppConfig.class,loader=AnnotationConfigContextLoader.class)

public class AppTest {

 @Autowired

 private PaymentService sampleService;

 @BeforeClass

 public static void setUp() {

 System.out.println("-----> SETUP <-----");

 }

 @Test

 public void testSampleService() {

 assertEquals("class com.PaymentService.service.PaymentServiceImplementation",this.sampleService.getClass().toString());

 }

 @Test

 public void testSampleServiceGetAccountDescription() {

 //	Check if the return description has a 'Description:' string.

 assertTrue(sampleService.getPaymentDescription().contains("Description:"));

 }

 @Test

 public void testSampleServiceGetAccountCode() {

 //	Check if the return description has a 'Code:' string.

 assertTrue(sampleService.getPaymentCode().contains("Code:"));

 }

 @Test

 public void testSampleServiceCreateNewOrder() {

 Payment newPayment = new Payment();

 newPayment.setPaymentCode("1234");

 newPayment.setPaymentDescription("Description");

 if(newPayment != null) {

 

  assertNotNull("Payment isn't null", newPayment.getPaymentCode());

  assertNotNull("Description isn't not null", newPayment.getPaymentDescription());

 }

 assertNotNull("New Payment is not null", newPayment);

 }

 @Test

 public void testSampleServiceGetOrder() {

 Payment existingPayment = sampleService.getPayment(0);

 if(existingPayment != null) {

  assertThat(sampleService.getPayment(0), instanceOf(Payment.class));

  assertNotNull("Payment isn't null", existingPayment.getPaymentCode());

  assertNotNull("Description isn't null", existingPayment.getPaymentDescription());

 }

 assertNotNull("Payemnt is not null", existingPayment);

 }

 @AfterClass

 public static void afterTest() {

 System.out.println("-----> DESTROY <-----");

 }

}


