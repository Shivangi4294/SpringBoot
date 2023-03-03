package com.wissen.participant.participantRepository;

import java.util.*;

public class ParticipantRepository {

    @Query("SELECT * FROM participants")
    List<Participant> getAllParticipants;

}