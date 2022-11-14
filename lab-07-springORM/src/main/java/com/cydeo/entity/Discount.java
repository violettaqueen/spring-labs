package com.cydeo.entity;

import com.cydeo.enums.DiscountType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Discount extends BaseEntity{

    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private String name;

    public Discount(BigDecimal discount, DiscountType discountType, String name) {
        this.discount = discount;
        this.discountType = discountType;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discount=" + discount +
                ", discountType=" + discountType +
                ", name='" + name + '\'' +
                '}';
    }
}
