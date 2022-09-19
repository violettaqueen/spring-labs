package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class Config {

    @Bean
    public Current current(Currency currency){ //we had to set all fields because we do not have a constructor
        Current current = new Current();
        current.setAccountId(UUID.randomUUID());
        current.setAmount(new BigDecimal(670));
        current.setCurrency(currency); //autowiring
        return current;
    }
    @Bean
    public Currency currency(){
        return new Currency("113", "Dollar");
    }
    @Bean
    public Saving savings(){
        Saving savings = new Saving();
        savings.setAccountId(UUID.randomUUID());
        savings.setAmount(new BigDecimal(500));
        savings.setCurrency(new Currency("112", "Dollar"));
        return savings;

    }
}
