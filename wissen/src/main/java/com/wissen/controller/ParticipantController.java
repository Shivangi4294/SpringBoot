package com.wissen.controller;

import com.wissen.entity.Participant;
import com.wissen.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ParticipantController {

    @Autowired
    ParticipantRepository repository;

    @PostMapping(path = "/insertParticipant")
    public ResponseEntity<String> insertParticipants(){

        Participant p1 = new Participant(1,"Hari","wissen","tech","dev");
        repository.save(p1);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping(path = "api/bulkParticipants")
//    public ResponseEntity<String> insertParticipants(@RequestBody List<Participant> participants){
    public void insertParticipants(@RequestBody List<Participant> participants){

        repository.saveAll(participants);

//        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @GetMapping(path ="api/getAllParticipants")     //@RequestMapping(method = RequestMethod.GET)
//    public List<Participant> getAllParticipants(){
//        List<Participant> participantsList = repository.getAllParticipants;
//        return participantsList;
//    }
//    @GetMapping(path ="api/getParticipantById")     //@RequestMapping(method = RequestMethod.GET)
//    public List<Participant> getAllParticipants(){
//        List<Participant> participantsList = repository.getAllParticipants;
//        return participantsList;
//    }

}