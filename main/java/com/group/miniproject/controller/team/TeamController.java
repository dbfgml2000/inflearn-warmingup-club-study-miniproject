package com.group.miniproject.controller.team;

import com.group.miniproject.domain.team.Team;
import com.group.miniproject.dto.team.request.TeamSaveRequest;
import com.group.miniproject.dto.team.response.TeamResponse;
import com.group.miniproject.service.team.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/team")
    public void saveTeam(@RequestBody TeamSaveRequest request){
        teamService.saveTeam(request);
    }

    @GetMapping("/team")
    public List<TeamResponse> getTeams(){
        return teamService.getTeams();
    }
}
