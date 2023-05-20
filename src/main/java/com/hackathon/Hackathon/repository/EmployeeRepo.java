package com.hackathon.Hackathon.repository;

import com.hackathon.Hackathon.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    Employee findByEmail(String email);

    Optional<Employee> findByEmailAndPassword(String email, String encodedPassword);
}
