package com.hackathon.Hackathon.service;

import com.hackathon.Hackathon.dto.EmployeeDto;
import com.hackathon.Hackathon.dto.LoginDto;
import com.hackathon.Hackathon.response.LoginResponse;

public interface EmployeeService {


    String addEmployee(EmployeeDto employeeDto);

    LoginResponse loginEmployee(LoginDto loginDto);
}
