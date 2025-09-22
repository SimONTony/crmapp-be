package com.crmapp.Fops;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fops")
public class FopsEntity {


    @Column
    private Integer fopId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String phone;
    @Id
    private Long id;

    public FopsEntity(Integer fopId, String name, String email, String address, String phone) {
        this.fopId = fopId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public FopsEntity() {

    }


    @Override
    public String toString() {
        return "FopsEntity{" +
                "fopId=" + fopId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


}


