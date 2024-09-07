package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.config.AppConfig;
import com.nt.constant.PropertiesCons;
import com.nt.model.Player;
import com.nt.repo.IPlayerRepo;

@Service
public class TeamPlayerMngimpl implements ITeamPlayerMng {
	/*
	 * @Autowired private ITeamRepo team;
	 */
	@Autowired
	private IPlayerRepo playerRepo;
	
	private Map<String,String> msg;
	
	@Autowired
	public TeamPlayerMngimpl(AppConfig cfg) {
		msg=cfg.getProps();
	}
	
	@Override
	public String savePlayer(Player player) {
		playerRepo.save(player);
		System.out.println(msg.get("save"));
		return player.getPlayerId() +msg.get( PropertiesCons.SAVE_OBJ);
	}

	@Override
	public String deletePlayer(Integer id) {
		/*
		 * Player p= playerRepo.findById(id).orElseThrow(()->new
		 * IllegalArgumentException("Player Object is not found with id value "+id));
		 * playerRepo.delete(p); return null;
		 */
		 Optional<Player> p= playerRepo.findById(id);
		 if(p.isPresent()) {
			 playerRepo.deleteById(id);
			 return msg.get(PropertiesCons.DELETE_OBJ)+id;
		 }else {
			 return msg.get(PropertiesCons.NOTDELETE_OBJ)+id;
		 }
		
	}

	@Override
	public String updatePlayer(Player player) {
		Optional<Player> p= playerRepo.findById(player.getPlayerId());
		 if(p.isPresent()) {
			 playerRepo.save(player);
			 return msg.get(PropertiesCons.UPDATE_OBJ)+player.getPlayerId();
		 }else {
			 return msg.get(PropertiesCons.NOTUPDATE_OBJ)+player.getPlayerId();
		 }
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerRepo.findAll();
	}

	@Override
	public Player getPlayerById(Integer id) {
		Player p= playerRepo.findById(id).orElseThrow(()->new IllegalArgumentException(msg.get(PropertiesCons.EXE_OBJ)+id));
		return p;
	}

	@Override
	public String changePlayerStatus(Integer id, String status) {
		Optional<Player> p= playerRepo.findById(id);
		 if(p.isPresent()) {
			Player pl=p.get();
			pl.setStatus(status);
			playerRepo.save(pl);
			 return msg.get(PropertiesCons.STATUA_OBJ);
		 }else {
			 return msg.get(PropertiesCons.NOTSTATUS_OBJ);
		 }
	}

	@Override
	public String saveListOfPlayers(List<Player> list) {
		List<Player> pl= playerRepo.saveAll(list);
		int num=pl.size();
		List<Integer> in=pl.stream().map(items->items.getPlayerId()).collect(Collectors.toList());
		return num+" of Player Objects are saved with id values "+in.toString();
	}

}
