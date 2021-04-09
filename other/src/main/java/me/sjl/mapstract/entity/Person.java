package me.sjl.mapstract.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Person {

    private String name;

    private Integer age;

    private LocalDate createTime;


}
