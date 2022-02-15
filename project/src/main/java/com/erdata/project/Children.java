package com.erdata.project;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.erdata.project.Security.Person;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
public class Children extends Person{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "you have to provide the child's birth date!")
    private String birthdate;
    @Column(nullable = true, length = 64)
    private String photos;
    @NotEmpty(message="atleast one sentence information  is required")
    @Length(min=15, max = 200, message = "write description with 15 - 200 characters")
    private String description;
    @Temporal(TemporalType.DATE)
    private Date registered_Date = new Date(System.currentTimeMillis());

    @Embedded
    private BankAccount bankAccount; 

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;
         
        return "/user-photos/" + id + "/" + photos;
    }
}