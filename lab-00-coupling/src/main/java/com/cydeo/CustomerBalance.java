package com.cydeo;

import com.cydeo.loosely.Balance;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CustomerBalance extends Balance {

    public CustomerBalance(UUID userId, BigDecimal amount) {
        super(userId, amount);
    }

    @Override
    public BigDecimal addBalance(BigDecimal amount) {
        setAmount(this.getAmount().add(amount));
        return this.getAmount();
    }
}
