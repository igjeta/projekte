package com.shop.controller;

import com.shop.domain.dto.shippingaddress.ShippingAddressCreateUpdateDto;
import com.shop.domain.dto.shippingaddress.ShippingAddressDto;
import com.shop.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class ShippingAddressController {

    @Autowired
    private ShippingAddressService addressService;

    @GetMapping()
    public List<ShippingAddressDto> getAllAddresses() {
        return addressService.getAllShippingAddress();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAddress(@RequestBody ShippingAddressCreateUpdateDto addressDto) {
        addressService.createShippingAddress(addressDto);
        return ResponseEntity.ok("Shipping Address create successfully!");
    }


    @PostMapping("/update/{addressId}")
    public ResponseEntity<String> updateAddress(@RequestBody ShippingAddressCreateUpdateDto addressDto, @PathVariable Integer addressId) {
        addressService.updateShippingAddress(addressDto, addressId);
        return ResponseEntity.ok("Shipping address updated successfully!");
    }

    @PutMapping("/action/{addressId}")
    public ResponseEntity<String> actionAddress(@PathVariable Integer addressId, @RequestParam Boolean enabled) {
        addressService.disableShippingAddress(addressId, enabled);
        return ResponseEntity.ok("Address with id " + addressId + " has been disabled successfully!");
    }
}