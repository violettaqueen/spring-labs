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
    public Current current(){
        return new Current();
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
