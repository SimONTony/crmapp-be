package com.crmapp.person;

import lombok.*;

import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonEditDto {

    private int personId;
    private String firstName;
    private String surname;
    private String lastname;
    private boolean hasFop;
    private String email;
    //    private String gender;
//    private String phone;
    private Date birthday;


}
