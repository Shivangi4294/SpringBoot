package com.wissen.repository;

import com.wissen.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant,Integer>{

    List<Participant> findAll();
}