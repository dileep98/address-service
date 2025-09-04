package com.dk.addressservice.controller;

import com.dk.addressservice.response.AddressResponse;
import com.dk.addressservice.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public String getAddress(){
        return "Delray Beach, Florida";
    }

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId){

        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressByEmployeeId(employeeId));

    }
}
