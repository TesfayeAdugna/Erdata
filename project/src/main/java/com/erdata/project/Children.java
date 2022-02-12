package com.erdata.project;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Children {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message="this value is required")
    private String firstname;
    private String middlename;
    private String lastname;
    @NotEmpty(message="this value is required")
    private String birthdate;
    private String gender;
    @NotEmpty(message="this value is required")
    private String address;
    private String bankaccount;
    @Column(nullable = true, length = 64)
    private String photos;
    @NotEmpty(message="this value is required")
    private String description;
    @Temporal(TemporalType.DATE)
    private Date registered_Date = new Date(System.currentTimeMillis());

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;
         
        return "/user-photos/" + id + "/" + photos;
    }
}
