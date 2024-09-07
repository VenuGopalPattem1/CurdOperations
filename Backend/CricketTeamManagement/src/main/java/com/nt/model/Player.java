package com.nt.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PLAYER_TABLE")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer playerId;
	private String name;
	private String role;
	private Integer salary;
	private String nation;
	private String status="active";
//	@CreationTimestamp
//	private LocalDateTime createdTime;
//	@UpdateTimestamp
//	private LocalDateTime updateTime;
	
	
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(referencedColumnName = "teamId") 
	  private Team team;
	 

}
