package com.cydeo.entity;

import com.cydeo.enums.PaymentMethod;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Payment extends BaseEntity{


    private BigDecimal paidPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Override
    public String toString() {
        return "Payment{" +
                "paidPrice=" + paidPrice +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
