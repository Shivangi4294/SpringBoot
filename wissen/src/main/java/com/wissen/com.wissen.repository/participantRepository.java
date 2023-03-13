package com.wissen.repository;

import java.util.*;
//import spring.jpa.properties.hibernate.jdbc.batch_size;
public class ParticipantRepository {


    @Query("SELECT * FROM participants")
    List<Participant> getAllParticipants;

}