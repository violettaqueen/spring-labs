package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Integer remaining_quantity;

    @ManyToMany
    @JoinTable(name = "product_category_rel",
            joinColumns = @JoinColumn(name = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Category> categoryList;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", remaining_quantity=" + remaining_quantity +
                '}';
    }
}
