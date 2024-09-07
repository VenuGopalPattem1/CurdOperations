package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Player;
import com.nt.service.TeamPlayerMngimpl;


@RestController
@RequestMapping("/app")
@CrossOrigin
public class TeamPlayerController {
	
	@Autowired
	private TeamPlayerMngimpl ser;
	
	@PostMapping("/save")
	public ResponseEntity<String> savePlayer(@RequestBody Player p){
		String msg=ser.savePlayer(p);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Player>> getAll(){
		List<Player> li=ser.getAllPlayers();
		return new ResponseEntity<List<Player>>(li, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		String msg=ser.deletePlayer(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Player> getByid(@PathVariable Integer id){
		Player msg=ser.getPlayerById(id);
		return new ResponseEntity<Player>(msg, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatePlayer(@RequestBody Player p){
		String msg=ser.updatePlayer(p);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/up/{id}/{status}")
	public ResponseEntity<String> updatePlayerStatus(@PathVariable Integer id ,
			                                                                                           @PathVariable String status){
		String msg=ser.changePlayerStatus(id,status);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PostMapping("/save-all")
	public ResponseEntity<String> saveAllPlayers(@RequestBody List<Player> list){
		String msg = ser.saveListOfPlayers(list);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	
	
}
