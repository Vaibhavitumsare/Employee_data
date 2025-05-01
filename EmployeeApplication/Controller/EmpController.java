package com.SpringProject.EmployeeApplication.Controller;


import com.SpringProject.EmployeeApplication.Model.Employee;
import com.SpringProject.EmployeeApplication.Service.EmpService;
import com.SpringProject.EmployeeApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmpController {

   // List<Employee> employees=new ArrayList<>();
   //dependency injection

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){

        return employeeService.getEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeesById( @PathVariable Long id){
        System.out.println("here's your data");
        return employeeService.readEmployee(id);
    }

    @GetMapping("employees/search")
    public List<Employee> getEmployeesByName( @RequestParam String name){
        return employeeService.findByName(name);
    }

    @PostMapping("employees")
    public String createEmployee( @RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return "saved successfully";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
       if( employeeService.deleteEmployee(id))
       {return "deleted successfully";}

       return "deleted failed";
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);
        return "updated successfully";

    }


}
