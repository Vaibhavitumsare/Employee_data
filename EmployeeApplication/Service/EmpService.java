package com.SpringProject.EmployeeApplication.Service;

import com.SpringProject.EmployeeApplication.Model.Employee;
import com.SpringProject.EmployeeApplication.Repo.EmployeeRepository;
import com.SpringProject.EmployeeApplication.entity.EmployeeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmpService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    List<Employee> employees=new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
       EmployeeEntity employeeEntity=new EmployeeEntity();
       BeanUtils.copyProperties(employee,employeeEntity);

       employeeRepository.save(employeeEntity);
        //employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employees= employeeRepository.findAll();
        List<Employee> employees1=new ArrayList<>();
        for (EmployeeEntity employeeEntity : employees) {
            Employee employee=new Employee();
            BeanUtils.copyProperties(employeeEntity,employee);
            employees1.add(employee);
        }
        return employees1;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp=employeeRepository.findById(id).get();
        employeeRepository.delete(emp);

        //employees.remove(id);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity Existingemp=employeeRepository.findById(id).get();
        Existingemp.setName(employee.getName());
        Existingemp.setEmail(employee.getEmail());
        Existingemp.setPhoneNumber(employee.getPhoneNumber());
        employeeRepository.save(Existingemp);

        return "Updated Successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity emp=employeeRepository.findById(id).get();
        Employee employees=new Employee();
        BeanUtils.copyProperties(emp,employees);
        return employees;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<EmployeeEntity> employeeEntities = employeeRepository.findByNameContainingIgnoreCase(name);
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity entity : employeeEntities) {
            Employee emp = new Employee();
            BeanUtils.copyProperties(entity, emp);
            employees.add(emp);
        }

        return employees;
    }



}
