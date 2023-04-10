package com.example.springboot101.controller;

import com.example.springboot101.entity.ShippingAddress;
import com.example.springboot101.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipping-addresses")
public class ShippingAddressController {

    @Autowired
    private ShippingAddressService shippingAddressService;

    @GetMapping("")
    public List<ShippingAddress> getAllShippingAddresses() {
        return shippingAddressService.getAllShippingAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingAddress> getShippingAddressById(@PathVariable Long id) {
        ShippingAddress shippingAddress = shippingAddressService.getShippingAddressById(id);
        if (shippingAddress == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shippingAddress);
    }

    @PostMapping("")
    public ShippingAddress createShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        return shippingAddressService.createShippingAddress(shippingAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingAddress> updateShippingAddress(@PathVariable Long id, @RequestBody ShippingAddress shippingAddress) {
        ShippingAddress updatedShippingAddress = shippingAddressService.updateShippingAddress(id, shippingAddress);
        if (updatedShippingAddress == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedShippingAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingAddress(@PathVariable Long id) {
        boolean success = shippingAddressService.deleteShippingAddress(id);
        if (!success) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
