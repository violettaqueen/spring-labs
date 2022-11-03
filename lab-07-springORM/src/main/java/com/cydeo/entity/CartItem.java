package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Data
public class CartItem extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "quantity")
    private Product quantity;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;





}
