package com.cydeo.service;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.CustomerDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> getAllAddress();
    AddressDTO save(AddressDTO address);

    List<AddressDTO> getAddressListByStartsWithAddress(String name);
    List<AddressDTO> getAddressListByCustomerId(Long id);
    List<AddressDTO> getAddressListByCustomerIdAndName(Long id, String name);
    AddressDTO update(AddressDTO address);


}
