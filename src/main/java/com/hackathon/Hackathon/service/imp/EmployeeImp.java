package com.hackathon.Hackathon.service.imp;

import com.hackathon.Hackathon.dto.EmployeeDto;
import com.hackathon.Hackathon.dto.LoginDto;
import com.hackathon.Hackathon.entity.Employee;
import com.hackathon.Hackathon.repository.EmployeeRepo;
import com.hackathon.Hackathon.response.LoginResponse;
import com.hackathon.Hackathon.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeImp implements EmployeeService {

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
    @Override
    public LoginResponse loginEmployee(LoginDto loginDto) {
        String msg ="";
        Employee employee = employeeRepo.findByEmail(loginDto.getEmail());
        if (employee != null){
            String password = loginDto.getPassword();
            String encodedPassword = employee.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password,encodedPassword);
            if (isPwdRight){
                Optional<Employee> employee1 = employeeRepo.findByEmailAndPassword(loginDto.getEmail(),encodedPassword);
                if (employee1.isPresent()){
                    return new LoginResponse("Login Success",true);
                }else {
                    return  new LoginResponse("Login Failed",false);
                }
            }else {
                return new LoginResponse("password not match",false);
            }
        }else {
            return new LoginResponse("Email not exits",false);
        }
    }


}
