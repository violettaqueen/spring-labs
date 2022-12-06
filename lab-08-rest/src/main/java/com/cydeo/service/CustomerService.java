package com.cydeo.service;

import com.cydeo.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO findById(Long id);
}
