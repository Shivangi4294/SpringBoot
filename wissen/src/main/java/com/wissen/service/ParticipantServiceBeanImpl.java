package com.wissen.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.wissen.entity.Participant;
import com.wissen.exception.IdNotFoundException;
import com.wissen.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ParticipantServiceBeanImpl implements ParticipantService {
    @Autowired
    private ParticipantRepository repository;


    @Override
    public List<Participant> uploadCSVFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new NullPointerException("No File uploaded");
        }
        List<Participant> participantList;
        try {
            Reader reader = new InputStreamReader(file.getInputStream());

            CSVReader csvReader = new CSVReaderBuilder(reader).build();

            CsvToBean<Participant> csvToBean = new CsvToBeanBuilder<Participant>(csvReader)
                    .withType(Participant.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            participantList = csvToBean.parse();
            repository.saveAll(participantList);
            csvReader.close();
        } catch (IOException exception) {
            throw new RuntimeException("Error while processing file");
        }
        return participantList;
    }

    public List<Participant> insertBulkParticipants(List<Participant> participants) {
        return repository.saveAll(participants);
    }

    public Participant getParticipantById(int id) {
        Participant participant;
        Optional<Participant> optional = repository.findById(id);
        if (optional.isPresent()) {
            participant = optional.get();
        } else {
            throw new IdNotFoundException("Participant with id: "+id+" not found.");
        }
        return participant;
    }

    public List<Participant> getAllParticipants() {
        return repository.findAll();
    }

}
