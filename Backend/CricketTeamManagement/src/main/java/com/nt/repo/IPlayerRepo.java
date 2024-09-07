package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Player;

public interface IPlayerRepo extends JpaRepository<Player,Integer> {

}
