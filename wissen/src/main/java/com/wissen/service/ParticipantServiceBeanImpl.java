package com.wissen.service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.wissen.entity.Participant;
import com.wissen.exception.IdNotFoundException;
import com.wissen.exception.MandatoryFieldException;
import com.wissen.exception.ParticipantNotFoundException;
import com.wissen.repository.ParticipantRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public  class ParticipantServiceBeanImpl implements ParticipantService {
    Logger logger = LoggerFactory.getLogger(ParticipantServiceBeanImpl.class);
    @Autowired
    private ParticipantRepository repository;

    @Override
    public List<Participant> uploadCSVFile() throws IOException {
        List<Participant> participantList=null;
        try {
//            FileReader filereader = new FileReader("C:\\SpringBootProject\\file.csv");
//            File file = new File("C:\\SpringBootProject\\file.csv");
//            Reader filereader = Files.newBufferedReader(file.toPath());
            CSVReader reader = new CSVReader(new FileReader("C:\\SpringBootProject\\file1.csv"));

            CsvToBean<Participant> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Participant.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            participantList = csvToBean.parse();
            repository.saveAll(participantList);
            reader.close();
        }
        catch (java.io.FileNotFoundException exception){
            throw new FileNotFoundException();
        } catch (IOException exception) {
            throw new IOException();
        }
        return participantList;
    }
    public ResponseEntity<Participant> insertParticipant(Participant participant)  {
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
