package com.crmapp.person;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;

    @Column
    private String firstname;

    @Column
    private String surname;

    @Column
    private String lastname;

    @Column
    private Boolean hasFop;

    @Column
    private String email;

//    @Column
//    private String gender;
//
//    @Column
//    private Integer phone;

    @Column
    private Date birthday;



}




