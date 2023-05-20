package com.hackathon.Hackathon.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "employee_Name" , length = 25)
    private String employeeName;
    @Column(name = "email" , length = 30)
    private String email;

    @Column(name = "password", length = 10)
    private String password;

    public Employee(Integer id,String employeeName, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.employeeName=employeeName;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
