package com.wissen.service;

import com.wissen.entity.Participant;
import com.wissen.exception.MandatoryFieldException;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
public interface ParticipantService {
    ResponseEntity<Participant> insertParticipant(Participant participant) throws MandatoryFieldException;
    List<Participant> insertBulkParticipants(List<Participant> participants);
    Participant getParticipantById(int id);
    List<Participant> getAllParticipants();
    List<Participant> uploadCSVFile(MultipartFile file);
}
