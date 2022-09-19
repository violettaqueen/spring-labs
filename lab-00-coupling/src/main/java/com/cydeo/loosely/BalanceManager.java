package com.cydeo.loosely;

import com.cydeo.CustomerBalance;
import com.cydeo.GiftCardBalance;
import com.cydeo.tightly.BalanceService;

import java.math.BigDecimal;

public class BalanceManager{

    private final Balance balance;


    public BalanceManager(Balance balance, BigDecimal amount) {
        this.balance = balance;

    }

    public boolean checkout(Balance balance, BigDecimal amount
                            // add method parameters
    ){
        // implement checkout business
        BigDecimal balanceAmount = balance.getAmount();
        return balance.getAmount().subtract(amount)
                .compareTo(BigDecimal.ZERO) > 0;


    }
}
