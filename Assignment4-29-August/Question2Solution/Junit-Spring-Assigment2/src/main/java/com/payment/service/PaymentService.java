package com.payment.service;
import com.payment.model.Payment;
public interface PaymentService {

	 public String getPaymentDescription();

	 public String getPaymentCode();

	 public Payment getPayment(int id);

	 public Payment createPayment(Payment Payment);

	}