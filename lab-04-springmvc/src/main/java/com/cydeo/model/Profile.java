package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Profile {
    private String email;
    private String phoneNumber;
    private String name;
    private String surname;
    private String userName;
    private LocalDateTime createdDate;
}