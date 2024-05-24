package com.group.miniproject.dto.team.response;

public class TeamResponse {
    private String name;
    private String manager;
    private int memberCount;

    public TeamResponse(String name, String manager, int memberCount) {
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public int getMemberCount() {
        return memberCount;
    }
}
