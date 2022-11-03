package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Customer extends BaseEntity{

    private String email;
    private String firstName;
    private String lastName;
    private String userName;

    @OneToMany(mappedBy = "customer")
    private List<Address> addressList;


}
