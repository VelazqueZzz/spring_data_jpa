package com.springbootJPA.controller;



import com.springbootJPA.entity.Employee;
import com.springbootJPA.sevice.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private final EmployeeService employeeService;

    public MyRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){

        return employeeService.getEmployee(id);

    }
@PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
}
@PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
}
@DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
    employeeService.getEmployee(id);

    employeeService.deleteEmployee(id);
        return "Employee with ID= "+id+" was deleted";
}
@GetMapping("/employees/name/{name}")
public List<Employee>showAllEmployeesByName(@PathVariable String name){
        List<Employee>employees=employeeService.findAllByName(name);
        return employees;
}
}
