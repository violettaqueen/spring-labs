package com.cydeo.service.impl;

import com.cydeo.dto.AddressDTO;
import com.cydeo.entity.Address;
import com.cydeo.entity.Customer;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.AddressRepository;
import com.cydeo.service.AddressService;
import com.cydeo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final CustomerService customerService;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
    }


    @Override
    public List<AddressDTO> getAllAddress() {

        List<Address> addressList = addressRepository.findAll();

        return addressList.stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        Address addressToSave = mapperUtil.convert(addressDTO, new Address());
        Customer customer = mapperUtil.convert(customerService.findById(addressDTO.getCustomerId()), new Customer());
        addressToSave.setCustomer(customer);
        addressRepository.save(addressToSave);
        return addressDTO;
    }
    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        Address addressToUpdate = mapperUtil.convert(addressDTO, new Address());
        Customer customer = mapperUtil.convert(customerService.findById(addressDTO.getCustomerId()), new Customer());
        addressToUpdate.setCustomer(customer);
        addressRepository.save(addressToUpdate);
        return addressDTO;

    }
    @Override
    public List<AddressDTO> getAddressListByStartsWithAddress(String name) {

        List<Address> addressList = addressRepository.findAllByStreetStartingWith(name);
        return addressList.stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());

    }

    @Override
    public List<AddressDTO> getAddressListByCustomerId(Long id) {
        List<Address> addressList = addressRepository.retrieveByCustomerId(id);
        return addressList.stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
        public List<AddressDTO> getAddressListByCustomerIdAndName(Long id, String name) {
            List<Address> addressList = addressRepository.findByCustomerIdAndName(id, name);
            return addressList.stream()
                    .map(address -> mapperUtil.convert(address, new AddressDTO()))
                    .collect(Collectors.toList());

    }



}
