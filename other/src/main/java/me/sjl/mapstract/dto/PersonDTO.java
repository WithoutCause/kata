package me.sjl.mapstract.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonDTO {

    private String name;

    private String age;

    private LocalDate createTime;

}
