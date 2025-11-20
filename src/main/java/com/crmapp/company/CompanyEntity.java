package com.crmapp.company;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column
    private String alias;

    @Column
    private String inn;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private Date founding;

    @Column(name = "category_of_activity")
    private String categoryOfActivity;

    @Column(name = "edrpou")
    private String edrpou;




}
