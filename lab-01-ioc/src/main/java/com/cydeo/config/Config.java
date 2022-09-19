package com.cydeo.config;

import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Current current(){
        return new Current();
    }
    @Bean
    public Saving savings(){
        return new Saving();
    }
}
