package com.example.springboot101.service;

import com.example.springboot101.dao.ShippingAddressRepository;
import com.example.springboot101.entity.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingAddressService {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    public List<ShippingAddress> getAllShippingAddresses() {
        return shippingAddressRepository.findAll();
    }

    public ShippingAddress getShippingAddressById(Long id) {
        return shippingAddressRepository.findById(id).orElse(null);
    }

    public ShippingAddress createShippingAddress(ShippingAddress shippingAddress) {
        return shippingAddressRepository.save(shippingAddress);
    }

    public ShippingAddress updateShippingAddress(Long id, ShippingAddress shippingAddress) {
        ShippingAddress existingShippingAddress = shippingAddressRepository.findById(id).orElse(null);
        if (existingShippingAddress == null) {
            return null;
        }
        existingShippingAddress.setAddress(shippingAddress.getAddress());
        existingShippingAddress.setCity(shippingAddress.getCity());
        existingShippingAddress.setState(shippingAddress.getState());
        existingShippingAddress.setCountry(shippingAddress.getCountry());
        existingShippingAddress.setZipCode(shippingAddress.getZipCode());
        return shippingAddressRepository.save(existingShippingAddress);
    }

    public boolean deleteShippingAddress(Long id) {
        ShippingAddress existingShippingAddress = shippingAddressRepository.findById(id).orElse(null);
        if (existingShippingAddress == null) {
            return false;
        }
        shippingAddressRepository.delete(existingShippingAddress);
        return true;
    }
}

