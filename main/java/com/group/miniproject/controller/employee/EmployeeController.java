package com.group.miniproject.controller.employee;

import com.group.miniproject.domain.employee.Employee;
import com.group.miniproject.dto.employee.request.EmployeeSaveRequest;
import com.group.miniproject.dto.employee.response.EmployeeResponse;
import com.group.miniproject.service.employee.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public void saveEmployee(@RequestBody EmployeeSaveRequest request){
        employeeService.saveEmployee(request);
    }

    @GetMapping("/employee")
    public List<EmployeeResponse> getEmployees(){
        return employeeService.getEmployees();
    }

}
