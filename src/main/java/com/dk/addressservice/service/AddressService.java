package com.dk.addressservice.service;

import com.dk.addressservice.entity.Address;
import com.dk.addressservice.repo.AddressRepository;
import com.dk.addressservice.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private ModelMapper modelMapper;
    private AddressRepository addressRepository;

    public AddressService(ModelMapper modelMapper, AddressRepository addressRepository) {
        this.modelMapper = modelMapper;
        this.addressRepository = addressRepository;
    }

    public AddressResponse getAddressByEmployeeId(int id){

        Address address = addressRepository.findAddressByEmployeeId(id)
                .orElseThrow(() -> new RuntimeException("Address not found for employeeId=" + id));
        return modelMapper.map(address, AddressResponse.class);
    }
}
