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

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
public class Children {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message="first name is required")
    @Length(min = 3,max = 16, message = "name must be between 3-16 character")
    private String firstname;
    private String middlename;
    @NotEmpty(message="first name is required")
    @Length(min = 3,max = 16, message = "name must be between 3-16 character")
    private String lastname;
    @NotEmpty(message="Birthdate is required")
    private String birthdate;
    @NotEmpty(message="Gender is required")
    private String gender;
    @NotEmpty(message="Address is required")
    private String address;
    private String bankaccount;
    @Column(nullable = true, length = 64)
    private String photos;
    @NotEmpty(message="atleast one sentence information  is required")
    @Length(min=15, max = 200, message = "write description with 15 - 200 characters")
    private String description;
    @Temporal(TemporalType.DATE)
    private Date registered_Date = new Date(System.currentTimeMillis());

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;
         
        return "/user-photos/" + id + "/" + photos;
    }
}
