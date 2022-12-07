package com.cydeo.service.impl;

import com.cydeo.dto.CustomerDTO;
import com.cydeo.entity.Customer;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.CustomerRepository;
import com.cydeo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        CustomerDTO customerDTO = mapperUtil.convert(customer, new CustomerDTO());
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(customer -> mapperUtil.convert(customer, new CustomerDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        Customer customer = customerRepository.retrieveByCustomerEmail(email);
        CustomerDTO customerDTO = mapperUtil.convert(customer, new CustomerDTO());
        return customerDTO;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customerToSave = mapperUtil.convert(customerDTO, new Customer());
        customerRepository.save(customerToSave);
        return customerDTO;
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        Customer customerToUpdate = mapperUtil.convert(customerDTO, new Customer());
        customerRepository.save(customerToUpdate);
        return customerDTO;
    }


}
