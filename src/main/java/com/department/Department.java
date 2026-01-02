package com.department;

import com.crmapp.Constants;
import com.crmapp.core.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Constants.TableName.DEPARTMENTS)
@Builder
public class Department extends BaseEntity {

    private String name;
    private String director;
    private String comment;

}
