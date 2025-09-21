package com.crmapp.person;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

@Column
private String firstName;

@Column
private String lastName;

@Column
private String email;

@Column
private String surname;

@Column
private Date birth;

@Column
private Boolean fop;

}

public PersonEntity() {
}



