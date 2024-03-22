package com.example.carparking.repository;

import com.example.carparking.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select e from Employee e where e.id = ?1")
    Employee findEmployeeById(Long id);

    @Query(value = "select e from Employee e where e.email = ?1")
    Employee findEmployeeByEmail(String email);
}
