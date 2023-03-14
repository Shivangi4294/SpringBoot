package com.wissen.controller;

@RestController
public class participantController {

    @Autowired
    ParticipantRepository repository;

    @PostMapping(path = "api/bulkParticipants")
    public ParticipantEntity<String> insertParticipants(@RequestBody Participant participants){
//        Participant participant1 = new Participant("1","Akash","O9", "DS","Data Scientist");
//        Participant participant2 = new Participant("2","Asit","Merlin", "Law","Lawyer");
//        Participant participant3 = new Participant("3","Shivi","Wissen", "Dev","Java Dev");
//        Participant participant4 = new Participant("4","Sudha","Li", "Management","Manager");
//        Participant participant5 = new Participant("5","Aditi","Bank", "Finance","Data");

//        List<Participant> participants = Arrays.asList(participant1,participant2,participant3,participant4,participant5);

        repository.saveAll(participants);

        return ParticipantEntity.created("/participants");
    }

    @GetMapping(path ="api/getAllParticipants")     //@RequestMapping(method = RequestMethod.GET)
    public List<Participant> getAllParticipants(){
        List<Participant> participantsList = repository.getAllParticipants;
        return participantsList;
    }
    @GetMapping(path ="api/getParticipantById")     //@RequestMapping(method = RequestMethod.GET)
    public List<Participant> getAllParticipants(){
        List<Participant> participantsList = repository.getAllParticipants;
        return participantsList;
    }

}