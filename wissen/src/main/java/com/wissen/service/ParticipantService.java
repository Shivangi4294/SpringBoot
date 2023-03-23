package com.wissen.service;

import com.wissen.entity.Participant;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface ParticipantService {
    List<Participant> insertBulkParticipants(List<Participant> participants);
    Participant getParticipantById(int id);
    List<Participant> getAllParticipants();
    List<Participant> uploadCSVFile(MultipartFile file);
    Page<Participant> displayAllParticipants(Integer pageNo, Integer pageSize);
}
