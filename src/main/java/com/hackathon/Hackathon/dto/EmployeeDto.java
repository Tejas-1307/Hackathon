package com.hackathon.Hackathon.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDto {

    private Integer id;
    private String employeeName;
    private String email;

    private String password;

    public EmployeeDto() {

    }

    public EmployeeDto(Integer id,String employeeName, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.employeeName=employeeName;
    }
}
