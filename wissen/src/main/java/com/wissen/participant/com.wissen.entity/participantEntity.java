package com.wissen.participant.participantEntity;

import javax.persistence.*;

@Entity(name = "participants")

public class Participant{
    @id
    int id;
    @Column(name = "participantName")
    String participantName;
    @Column(name = "organisation")
    String organisation;
    @Column(name = "department")
    String department;
    @Column(name = "designation")
    String designation;

    public Participant(){}
    public Participant(int id, String participantName, String organisation, String department, String designation) {
        this.id = id;
        this.participantName = participantName;
        this.organisation = organisation;
        this.department = department;
        this.designation = designation;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}