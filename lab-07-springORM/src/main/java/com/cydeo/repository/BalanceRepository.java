package com.cydeo.repository;


import com.cydeo.entity.Balance;
import com.cydeo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    //Write a derived query to check balance exists for specific customer
    boolean existsBy(Customer customer); // Long id?
    //Write a derived query to get balance for specific customer
    Optional<Balance> findByCustomer(Customer customer);
    //Write a native query to get top 5 max balance
    @Query(value = "select distinct top (5) amount from balance", nativeQuery = true)
    List<Balance> retrieveTop5();
    //Write a derived query to get all balances greater than or equal specific balance amount
    List<Balance> findByAmountGreaterThanEqual(BigDecimal amount);
    //Write a native query to get all balances less than specific balance amount
    @Query(value = "select * from balance where amount >= ?1", nativeQuery = true)
    List<Balance> retrieveALLLessThanBalanceAmount(@Param("amount") BigDecimal amount);
}