package com.wissen.controller;

import com.wissen.entity.Participant;
import com.wissen.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping(path = "/api/upload-csv-file")
    public List<Participant> uploadCSVFile() throws IOException {
        return participantService.uploadCSVFile();
    }

    @PostMapping(path = "/api/participants")
    public List<Participant> insertBulkParticipants(@RequestBody List<Participant> participants) {

        return participantService.insertBulkParticipants(participants);
    }

    @GetMapping(path = "/api/participants")
    public List<Participant> getAllParticipants() {
        return participantService.getAllParticipants();
    }

    @GetMapping(path = "/api/getParticipantById/{id}")
    public Participant getParticipantById(@PathVariable int id) {
        Participant participant = participantService.getParticipantById(id);
        return participant;
    }


}