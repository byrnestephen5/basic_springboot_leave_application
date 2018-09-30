package com.byrne.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamMember {
	@Id
	private String id;
	private String firstname;
	private String lastname;
	private int    teamid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getTeamid() {
		return teamid;
	}
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	
	@Override
	public String toString() {
		return "TeamMember [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", teamid=" + teamid
				+ "]";
	}
	

}
