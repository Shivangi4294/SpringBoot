package com.wissen.service;

import com.wissen.entity.Participant;
import com.wissen.exception.IdNotFoundException;
import com.wissen.exception.MandatoryFieldException;
import org.springframework.http.ResponseEntity;

import java.util.*;
public interface ParticipantService {
    ResponseEntity<Participant> insertParticipant(Participant participant) throws MandatoryFieldException;
    List<Participant> insertBulkParticipants(List<Participant> participants);
    Participant getParticipantById(int id);
    List<Participant> getAllParticipants();

}
