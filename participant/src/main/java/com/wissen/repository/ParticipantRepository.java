package com.wissen.repository;

import com.wissen.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

}