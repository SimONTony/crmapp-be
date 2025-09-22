package com.crmapp.person;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

@Column
private String firstName;

@Column
private String secondName;

@Column
private String lastName;

@Column
private Boolean HasFop;

@Column
private String email;

@Column
private byte gender;

@Column
private int phone;

@Column
private String address;

@Column
private Date birth;


    public PersonEntity(int person_id, String firstName, String secondName, String lastName, Boolean hasFop, String email, byte gender, int phone, String address, Date birth) {
        this.person_id = person_id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        HasFop = hasFop;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
    }

    public PersonEntity() {
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "person_id=" + person_id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", HasFop=" + HasFop +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                '}';
    }

}




