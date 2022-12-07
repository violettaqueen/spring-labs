package com.cydeo.controller;

import com.cydeo.dto.CustomerDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.entity.Customer;
import com.cydeo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getCustomerList() {
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        return ResponseEntity.ok(new ResponseWrapper("Customers are successfully retrieved", customerDTOList, HttpStatus.OK));
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseWrapper> getCustomerByEmail(@PathVariable("email") String email) {
        CustomerDTO customer = customerService.getCustomerByEmail(email);
        return ResponseEntity.ok(new ResponseWrapper("Customer is successfully retrieved", customer, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO);
        return ResponseEntity.ok(new ResponseWrapper("Customer is successfully created", customerDTO, HttpStatus.OK));

    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.update(customerDTO);
        return ResponseEntity.ok(new ResponseWrapper("Customer is successfully updated", customerDTO, HttpStatus.OK));

    }

}
