package com.group.miniproject.domain.team;

import com.group.miniproject.domain.employee.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(nullable = false, length = 20)
    private String name;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    protected Team(){}

    public Team(String name) {

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }
}
