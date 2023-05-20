package com.hackathon.Hackathon.controller;

import com.hackathon.Hackathon.response.LoginResponse;
import com.hackathon.Hackathon.dto.EmployeeDto;
import com.hackathon.Hackathon.dto.LoginDto;
import com.hackathon.Hackathon.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto){
        String id = employeeService.addEmployee(employeeDto);
        return id;
    }

    @PostMapping("login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDto){
        LoginResponse loginResponse = employeeService.loginEmployee(loginDto);
        return ResponseEntity.ok(loginResponse);
    }

}
