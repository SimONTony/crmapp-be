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

    private int personId;
    private String firstName;
    private String secondName;
    private String lastName;
    private boolean hasFop;
    private String email;
    private String gender;
    private String phone;
    private Date birthday;

}
