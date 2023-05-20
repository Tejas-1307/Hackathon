package com.hackathon.Hackathon.controller;

import com.hackathon.Hackathon.dto.EmployeeDto;
import com.hackathon.Hackathon.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto){
        String id = employeeService.addEmployee(employeeDto);
        return id;
    }

}
