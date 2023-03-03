package com.wissen.repository;

import java.util.*;

public class ParticipantRepository {

    @Query("SELECT * FROM participants")
    List<Participant> getAllParticipants;

}