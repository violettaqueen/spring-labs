package com.cydeo.repository;

import com.cydeo.entity.Address;
import com.cydeo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    //Write a derived query to get all address with a specific customer
    List<Address> findByCustomer(Customer customer);
    //Write a derived query to get address with a specific street
    Address findByStreet(String streetName);
    //Write a derived query to get top 3 address with a specific customer email
    List<Address> findTop3ByCustomerEmail(String email);
    //Write a derived query to get all address with a specific customer and name
    List<Address> findAllByCustomerAndName(Customer customer,String userName);
    //Write a derived query to list all address where the beginning of the street contains the keyword
    List<Address> findByStreetStartingWith(String keyword);
    //Write a JPQL query to get all address with a specific customerId
    @Query("select a from Address a where a.customer.id = ?1")
    List<Address> retrieveAllAddressByCustomerId(Long id);
}