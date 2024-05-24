package com.group.miniproject.domain.employee;

import com.group.miniproject.domain.team.Team;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 25)
    private String name;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false)
    private LocalDate workStartDate;

    @ManyToOne()
    @JoinColumn(name = "team_id")
    private Team team;

    protected Employee(){}

    public Employee(String name, String role, LocalDate birthday, LocalDate workStartDate, Team team) {
        this.name = name;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }

    public Team getTeam() {
        return team;
    }
}
