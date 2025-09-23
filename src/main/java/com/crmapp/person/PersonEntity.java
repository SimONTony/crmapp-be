package com.crmapp.person;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
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



}




