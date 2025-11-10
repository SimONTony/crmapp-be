package com.crmapp.contracts;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "contracts")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class ContractEntity {

    @Id
    @GeneratedValue
    @Column(name = "contract_id")
    private Long contractId;

    @Column(name = "person_id")
    private String personId;

    @Column(name = "company_id")
    private String companyId;

    @Column
    private Date dated;

    @Column
    private String status;

    @Column
    private String alias;

    @Column
    private String number;


}
