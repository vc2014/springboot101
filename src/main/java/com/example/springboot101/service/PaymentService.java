package com.example.springboot101.service;

import com.example.springboot101.dao.PaymentRepository;
import com.example.springboot101.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = paymentRepository.findById(id).orElse(null);
        if(existingPayment == null){
            return null;
        }

        existingPayment.setPaymentMethod(payment.getPaymentMethod());
        existingPayment.setOrder(payment.getOrder());
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setTransactionDate(payment.getTransactionDate());

        return paymentRepository.save(existingPayment);
    }

    public boolean deletePayment(Long id) {
        Payment existingPayment = paymentRepository.findById(id).orElse(null);
        if(existingPayment == null){
            return false;
        }

        paymentRepository.delete(existingPayment);
        return true;
    }
}
