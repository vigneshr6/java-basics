package com.vignesh.basics.entity.repository;

import com.vignesh.basics.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
