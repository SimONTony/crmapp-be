package com.crmapp.company;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto {

    private Long companyId;
    private String companyName;
    private String alias;
    private String inn;
    private String phone;
    private String email;
    private String address;
    private Date founding;
    private String categoryOfActivity;
    private String edrpou;

}
