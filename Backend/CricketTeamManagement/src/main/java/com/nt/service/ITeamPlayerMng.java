package com.nt.service;

import java.util.List;

import com.nt.model.Player;

public interface ITeamPlayerMng {
	
	public String savePlayer(Player player);
	public String deletePlayer(Integer player);
	public String updatePlayer(Player player);
	public List<Player> getAllPlayers();
	public Player getPlayerById(Integer id);
	public String changePlayerStatus(Integer id,String status);
	public String saveListOfPlayers(List<Player> list);
}
