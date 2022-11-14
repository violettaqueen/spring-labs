package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity{

    private String email;
    private String firstName;
    private String lastName;
    private String userName;

    @OneToMany(mappedBy = "customer")
    private List<Address> addressList;

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
