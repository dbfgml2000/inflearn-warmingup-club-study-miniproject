package com.group.miniproject.dto.employee.request;

import java.time.LocalDate;

public class EmployeeSaveRequest {
    private String name;
    private String role;
    private LocalDate birthday;
    private LocalDate workStartDate;
    private Long teamId;

    public EmployeeSaveRequest(String name, String role, LocalDate birthday, LocalDate workStartDate, Long teamId) {
        this.name = name;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
        this.teamId = teamId;
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

    public Long getTeamId() {
        return teamId;
    }
}
