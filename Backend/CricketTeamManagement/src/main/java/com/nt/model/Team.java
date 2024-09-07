package com.nt.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TEAM_TABLE")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teamId;
	private String teamName;
	private String owner;
	private String loc;
	
//	@CreationTimestamp
//	private LocalDateTime createdTime;
//	@UpdateTimestamp
//	private LocalDateTime updateTime;
	
	@OneToMany(mappedBy = "team")
	@JsonIgnore
	private Set<Player> player;
}
