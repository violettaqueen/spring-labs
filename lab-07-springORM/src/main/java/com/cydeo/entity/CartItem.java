package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CartItem extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "quantity")
    private Product quantity;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;

    @Override
    public String toString() {
        return "CartItem{" +
                "quantity=" + quantity +
                '}';
    }
}
