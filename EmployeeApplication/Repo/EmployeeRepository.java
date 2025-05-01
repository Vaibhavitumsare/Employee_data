package com.SpringProject.EmployeeApplication.Repo;

import com.SpringProject.EmployeeApplication.Model.Employee;
import com.SpringProject.EmployeeApplication.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long > {

    // EmployeeRepository.java
    List<EmployeeEntity> findByNameContainingIgnoreCase(String name);

}
