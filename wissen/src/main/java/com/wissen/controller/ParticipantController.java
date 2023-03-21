package com.wissen.controller;

import com.wissen.entity.Participant;
import com.wissen.exception.IdNotFoundException;
import com.wissen.exception.MandatoryFieldException;
import com.wissen.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping(path = "/api/insertParticipant")
    public ResponseEntity<Participant> insertParticipant(@RequestBody Participant participant) throws MandatoryFieldException {

        return participantService.insertParticipant(participant);

    }
    @PostMapping(path = "/api/bulkParticipants")
    public List<Participant> insertBulkParticipants(@RequestBody List<Participant> participants){

        return participantService.insertBulkParticipants(participants);
    }

    @GetMapping(path ="/api/getAllParticipants")
    public List<Participant> getAllParticipants(){
        return participantService.getAllParticipants();
    }

    @GetMapping(path ="/api/getParticipantById/{id}")
    public Participant getParticipantById(@PathVariable int id) {
        Participant participant = participantService.getParticipantById(id);
        return participant;
    }


}