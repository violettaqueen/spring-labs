package com.cydeo.account;

import com.cydeo.Currency;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Component
public class Saving {
    private Currency currency;
    private BigDecimal amount;
    private UUID accountId;

    public void initialize(){
        System.out.println("savings account " + "currency: "+ currency.getCode() + "amount: " + amount + "accountId" + accountId);
    }
}
