package com.wissen.participant.participantController;

@RestController
public class participantController {

    @Autowired
    ParticipantRepository repository;
    @GetMapping(path ="api/getAllParticipants")     //@RequestMapping(method = RequestMethod.GET)
    public List<Participant> getAllParticipants(){
        List<Participant> participantsList = repository.getAllParticipants;
        return participantsList;
    }
}