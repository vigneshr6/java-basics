package com.vignesh.basics.jpa;

import com.vignesh.basics.entity.Department;
import com.vignesh.basics.entity.Employee;
import com.vignesh.basics.entity.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    @Order(1)
    @Transactional
    @Commit
    public void testInsert() {
        Employee e1 = new Employee(null, "Kirthana", Department.IT, 50000L);
        repository.save(e1);
        log.info("Inserted Employee: {}", e1);
    }

    @Test
    @Transactional
    @Commit
    @Order(2)
    public void testUpdate() {
        Employee e1 = repository.findById(2L).get();
        Assertions.assertNotNull(e1);
        log.info("Fetched Employee: {}", e1);
        e1.setSalary(60000L);
        log.info("Updated");
    }

    @Test
    @Transactional
    @Order(3)
    public void testRead() {
        Employee e1 = repository.findById(2L).get();
        Assertions.assertNotNull(e1);
        log.info("Fetched Employee: {}", e1);
        Assertions.assertEquals(60000L, e1.getSalary());
    }

    @Test
    @Transactional
    @Order(4)
    public void testReadEMData() {
        Employee e1 = repository.findById(1L).get();
        Assertions.assertNotNull(e1);
        log.info("Fetched Employee: {}", e1);
        Assertions.assertEquals(60000L, e1.getSalary());
    }
}
