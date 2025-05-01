package com.SpringProject.EmployeeApplication.Service;


import com.SpringProject.EmployeeApplication.Model.Employee;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeService {
    String createEmployee( Employee employee);
    List<Employee> getEmployees();
    boolean deleteEmployee( Long id);
    String updateEmployee( Long id, @RequestBody Employee employee);

    Employee readEmployee(Long id);

    List<Employee> findByName(String name);

}
