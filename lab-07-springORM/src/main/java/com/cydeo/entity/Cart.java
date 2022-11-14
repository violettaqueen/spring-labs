package com.cydeo.entity;

import com.cydeo.enums.CartState;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cart extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CartState cartState;

    @ManyToOne
    private Discount discount;

    @ManyToOne
    private Customer customer;

    public Cart(CartState cartState) {
        this.cartState = cartState;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartState=" + cartState +
                ", discount=" + discount +
                '}';
    }
}
