package com.spring.faisal.prodreadyfeatures.prodreadyfeatures.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {

    private Long id;


    private String name;


    private String email;

    private Integer age;



    private String role; //ADMIN, USER


    private Double salary;

    private LocalDate dateOfJoining;


    @JsonProperty("isActive")
    private Boolean isActive;
}
