package com.group.miniproject.service.team;

import com.group.miniproject.domain.employee.Employee;
import com.group.miniproject.domain.employee.EmployeeRepository;
import com.group.miniproject.domain.team.Team;
import com.group.miniproject.domain.team.TeamRepository;
import com.group.miniproject.domain.user.UserRepository;
import com.group.miniproject.dto.team.request.TeamSaveRequest;
import com.group.miniproject.dto.team.response.TeamResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private EmployeeRepository employeeRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveTeam(TeamSaveRequest request){
        Team t = teamRepository.save(new Team(request.getName()));
    }

    @Transactional(readOnly = true)
    public List<TeamResponse> getTeams(){
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(team -> {
            List<Employee> managers = team.getEmployees().stream().filter(emp -> "MANAGER".equals(emp.getRole())).collect(Collectors.toList());
            return new TeamResponse(
                    team.getName(),
                    (managers.isEmpty() ? null : managers.get(0).getName()),
                    team.getEmployees().size()
            );
        }).collect(Collectors.toList());
    }
}
