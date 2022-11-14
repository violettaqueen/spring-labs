package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String street;
    private String zipCode;

    @ManyToOne //many addresses, one customer
    private Customer customer;

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
