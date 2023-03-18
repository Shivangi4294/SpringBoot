package com.wissen.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity()
public class Participant{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;
    @Getter@Setter
    @Column(name = "participantName")
    String participantName;
    @Getter@Setter
    @Column(name = "organisation")
    String organisation;
    @Getter@Setter
    @Column(name = "department")
    String department;
    @Getter@Setter
    @Column(name = "designation")
    String designation;

    public Participant(){}
    public Participant(int id, String participantName, String organisation, String department, String designation) {
        this.id = id;
        this.participantName = participantName;
        this.organisation = organisation;
        this.department = department;
        this.designation = designation;
    }}