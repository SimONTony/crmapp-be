package com.crmapp.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {

    private Long personId;
    private String firstname;
    private String surname;
    private String lastname;
    private boolean hasFop;
    private String email;
    private Date birthday;

}