package com.example.springboot101.service;

import com.example.springboot101.dao.OrderRepository;
import com.example.springboot101.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        Order existingOrder = orderRepository.findById(id).orElse(null);

        if(existingOrder == null){
            return null;
        }

        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setProduct(order.getProduct());
        existingOrder.setPrice(order.getPrice());
        // set all the attributes

        return orderRepository.save(existingOrder);
    }


    public boolean deleteOrder(Long id) {
        Order existingOrder = orderRepository.findById(id).orElse(null);

        if(existingOrder == null){
            return false;
        }

        orderRepository.delete(existingOrder);
        return true;
    }
}
