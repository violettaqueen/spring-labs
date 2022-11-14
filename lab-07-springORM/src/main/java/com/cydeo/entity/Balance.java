package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Balance extends BaseEntity{

    private BigDecimal amount;

    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return "Balance{" +
                "amount=" + amount +
                '}';
    }
}
