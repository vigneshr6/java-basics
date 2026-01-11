package com.vignesh.basics.jpa;

import com.vignesh.basics.entity.Department;
import com.vignesh.basics.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JpaTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Order(1)
    @Transactional
    @Commit
    public void testInsert() {
        Employee e1 = new Employee(null, "Vignesh", Department.IT, 50000L);
        entityManager.persist(e1);
        log.info("Inserted Employee: {}", e1);
    }

    @Test
    @Transactional
    @Commit
    @Order(2)
    public void testUpdate() {
        Employee e1 = entityManager.find(Employee.class, 1L);
        Assertions.assertNotNull(e1);
        log.info("Fetched Employee: {}", e1);
        e1.setSalary(60000L);
        log.info("Updated");
        entityManager.find(Employee.class, 1L);
    }

    @Test
    @Transactional
    @Order(3)
    public void testRead() {
        Employee e1 = entityManager.find(Employee.class, 1L);
        Assertions.assertNotNull(e1);
        log.info("Fetched Employee: {}", e1);
        Assertions.assertEquals(60000L, e1.getSalary());
    }
}
