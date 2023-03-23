package com.wissen.controller;

import com.wissen.entity.Participant;
import com.wissen.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    @PostMapping(path ="/upload-csv-file")
    public List<Participant> uploadCSVFile(@RequestParam MultipartFile file) {
        return participantService.uploadCSVFile(file);
    }

    @PostMapping
    public List<Participant> insertBulkParticipants(@RequestBody List<Participant> participants) {
        return participantService.insertBulkParticipants(participants);
    }

    @GetMapping(path = "/{id}")
    public List<Participant> getParticipantById(@PathVariable String id) {
        if (id == null) {
            return participantService.getAllParticipants();
        }
        return List.of(participantService.getParticipantById(Integer.parseInt(id)));
    }
    @GetMapping
    public List<Participant> getAllParticipants(){

        return participantService.getAllParticipants();
    }
    @GetMapping(path = "/displayParticipants")
    public Page<Participant> displayAllParticipants(@RequestParam Integer pageNo, Integer pageSize){
        return participantService.displayAllParticipants(pageNo,pageSize);
    }


}