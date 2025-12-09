package com.crmapp.employee;

import com.crmapp.Constants;
import com.crmapp.core.model.BaseEntity;
import com.crmapp.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = Constants.TableName.EMPLOYEES, schema = Constants.DEFAULT_SCHEMA)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String firstname;

    @Column(length = 100, nullable = false)
    private String lastname;

    @Column(length = 100)
    private String patronymic;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "has_fop")
    private boolean hasFop;

    @Column(length = 50)
    private String phone;

    @Column
    private LocalDateTime birthday;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserEntity user;

}
