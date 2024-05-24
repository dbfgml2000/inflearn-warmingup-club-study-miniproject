package com.group.miniproject.service.employee;

import com.group.miniproject.domain.employee.Employee;
import com.group.miniproject.domain.employee.EmployeeRepository;
import com.group.miniproject.domain.team.Team;
import com.group.miniproject.domain.team.TeamRepository;
import com.group.miniproject.dto.employee.request.EmployeeSaveRequest;
import com.group.miniproject.dto.employee.response.EmployeeResponse;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private TeamRepository teamRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void saveEmployee(EmployeeSaveRequest request){

        Team team = teamRepository.findById(request.getTeamId()).orElseThrow(() -> new RuntimeException("해당하는 팀이 없습니다."));

        Employee e = employeeRepository.save(new Employee(
                request.getName(),
                request.getRole(),
                request.getBirthday(),
                request.getWorkStartDate(),
                team
        ));

        team.addEmployee(e);
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> getEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> new EmployeeResponse(
                employee.getName(),
                employee.getTeam().getName(),
                employee.getRole(),
                employee.getBirthday(),
                employee.getWorkStartDate()
        )).collect(Collectors.toList());
    }
}
