package com.cydeo.bootstrap;

import com.cydeo.model.Employee;

import java.util.Arrays;
import java.util.List;

public class DataGenerator{

    public static List<Employee> createEmployee(){

         List<Employee> employeeList = Arrays.asList(
                new Employee("Jon", "Brown"), new Employee("Liz", "Queen"),
                new Employee("Ann", "Stone")
        );
    }



}

