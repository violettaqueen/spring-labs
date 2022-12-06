package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.CustomerDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllAddresses() {
        List<AddressDTO> addressDTOList = addressService.getAllAddress();
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved", addressDTOList, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO addressDTO) {
        addressService.save(addressDTO);
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully created",addressDTO, HttpStatus.CREATED));
    }
    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO address) {
        addressService.update(address);
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully updated",address, HttpStatus.CREATED));
    }

    @GetMapping("/startsWith/{name}")
    public ResponseEntity<ResponseWrapper> getAddressStartsWith(@PathVariable("name") String name) {
        List<AddressDTO> addressDTOList = addressService.getAddressListByStartsWithAddress(name);
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved", addressDTOList, HttpStatus.OK));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("id") Long id) {

        List<AddressDTO> addressDTOList = addressService.getAddressListByCustomerId(id);
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved", addressDTOList, HttpStatus.OK));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerAndName(@PathVariable("customerId") Long id,
                                                                           @PathVariable("name") String name) {
        List<AddressDTO> addressDTOList = addressService.getAddressListByCustomerIdAndName(id, name);
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved", addressDTOList, HttpStatus.OK));
    }




}
