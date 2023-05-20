package com.hackathon.Hackathon.service;

import com.hackathon.Hackathon.dto.EmployeeDto;
import com.hackathon.Hackathon.entity.Employee;
import com.hackathon.Hackathon.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImp implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getEmployeeName(),
                employeeDto.getEmail(),

                this.passwordEncoder.encode(employeeDto.getPassword())


        );

        employeeRepo.save(employee);
        return employee.getEmployeeName();
    }
    EmployeeDto employeeDto;

}
