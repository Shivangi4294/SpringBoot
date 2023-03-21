package com.wissen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="participant")
    public class Participant implements Serializable {
    private static final long serialVersionUID=1L;
@SequenceGenerator(name="mysequence", initialValue=1)
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mysequence")
    @Id
    private int id;
    private String participantName;
    private String organisation;
    private String department;
    private String designation;


}