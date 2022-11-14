package com.cydeo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity{

    private String name;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
