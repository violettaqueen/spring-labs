package com.cydeo.entity;

import com.cydeo.enums.DiscountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class Discount extends BaseEntity{

    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private String name;




}
