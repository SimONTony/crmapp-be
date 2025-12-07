package com.crmapp.employee;

import com.crmapp.Constants;
import com.crmapp.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = Constants.TableName.EMPLOYEES)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(length = 100)
    private String firstname;

    @Column(length = 100)
    private String lastname;

    @Column(length = 100)
    private String patronymic;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private Boolean hasFop;

    @Column
    private String phone;

    @Column
    private LocalDateTime birthday;


}
