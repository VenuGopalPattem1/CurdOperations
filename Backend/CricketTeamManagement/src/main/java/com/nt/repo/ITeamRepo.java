package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Team;

public interface ITeamRepo extends JpaRepository<Team, Integer> {

}
