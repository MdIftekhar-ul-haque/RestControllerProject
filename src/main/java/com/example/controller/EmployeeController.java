package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

   
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {

        return service.addEmployee(employee);
    }

    
    @GetMapping
    public List<Employee> getAllEmployees() {

        return service.getAllEmployees();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(
            @PathVariable int id) {

        Employee employee = service.getEmployeeById(id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee employee) {

        Employee updatedEmployee =
                service.updateEmployee(id, employee);

        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedEmployee);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable int id) {

        String  result = service.deleteEmployee(id);

        if (result.equals("Employee not found")) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }
}