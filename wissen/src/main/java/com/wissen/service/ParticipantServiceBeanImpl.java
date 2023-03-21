package com.wissen.service;

import com.wissen.entity.Participant;
import com.wissen.exception.MandatoryFieldException;
import com.wissen.exception.ParticipantNotFoundException;
import com.wissen.repository.ParticipantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import org.slf4j.*;
import com.wissen.exception.IdNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@Slf4j
public  class ParticipantServiceBeanImpl implements ParticipantService {
    Logger logger = LoggerFactory.getLogger(ParticipantServiceBeanImpl.class);
    @Autowired
    private ParticipantRepository repository;
    public ResponseEntity<Participant> insertParticipant(Participant participant) throws MandatoryFieldException {
        if(participant.getParticipantName().isEmpty() || participant.getParticipantName().isBlank()) {
            throw new MandatoryFieldException();
        }
        return new ResponseEntity<>(repository.save(participant),HttpStatus.OK);
    }
    public List<Participant> insertBulkParticipants(List<Participant> participants){
        return repository.saveAll(participants);
    }

    public Participant getParticipantById(int id) {
        Participant participant;
        Optional<Participant> optional = repository.findById(id);
        if(optional.isPresent()){
            participant  = optional.get();
        }
        else{
            throw new IdNotFoundException();
        }
        return participant;
    }

    public List<Participant> getAllParticipants(){
        List<Participant> participantList = repository.findAll();
        if(participantList.isEmpty() ){
            throw new ParticipantNotFoundException();
        }
        return participantList;
    }
}
