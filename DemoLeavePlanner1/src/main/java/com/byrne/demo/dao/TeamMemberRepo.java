package com.byrne.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.byrne.demo.model.TeamMember;

public interface TeamMemberRepo extends JpaRepository<TeamMember,String> {

}
