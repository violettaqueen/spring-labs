package com.cydeo.entity;

import com.cydeo.enums.CartState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Cart extends BaseEntity{
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Discount discount;
    @Enumerated(EnumType.STRING)
    private CartState cartState;
}
