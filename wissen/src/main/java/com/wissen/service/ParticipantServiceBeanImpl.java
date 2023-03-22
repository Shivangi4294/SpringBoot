package com.wissen.service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.wissen.entity.Participant;
import com.wissen.exception.IdNotFoundException;
import com.wissen.exception.MandatoryFieldException;
import com.wissen.exception.ParticipantNotFoundException;
import com.wissen.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ParticipantServiceBeanImpl implements ParticipantService {
//    Logger logger = LoggerFactory.getLogger(ParticipantServiceBeanImpl.class);
    @Autowired
    private ParticipantRepository repository;



    @Override
    public List<Participant> uploadCSVFile(MultipartFile file) {
        if(file.isEmpty()){
            throw new NullPointerException("No File uploaded");
        }
        List<Participant> participantList = null;
        try {
            Path filePath = Paths.get(new File(file.getOriginalFilename()).getAbsolutePath());
            CSVReader csvReader = new CSVReader(new FileReader(String.valueOf(filePath)));

            CsvToBean<Participant> csvToBean = new CsvToBeanBuilder(csvReader)
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

    public ResponseEntity<Participant> insertParticipant(Participant participant) {
        if (participant.getParticipantName().isEmpty() || participant.getParticipantName().isBlank()) {
            throw new MandatoryFieldException();
        }
        return new ResponseEntity<>(repository.save(participant), HttpStatus.OK);
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
            throw new IdNotFoundException();
        }
        return participant;
    }

    public List<Participant> getAllParticipants() {
        List<Participant> participantList = repository.findAll();
        if (participantList.isEmpty()) {
            throw new ParticipantNotFoundException();
        }
        return participantList;
    }


}
