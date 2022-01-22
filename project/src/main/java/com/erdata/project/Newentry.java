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

import lombok.Data;

@Data
@Entity
public class Newentry {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String birthdate;
    private String gender;
    private String address;
    private String bankaccount;
    @Column(nullable = true, length = 64)
    private String photos;
    private String decription;
    @Temporal(TemporalType.DATE)
    private Date registered_Date = new Date(System.currentTimeMillis());

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;
         
        return "/user-photos/" + id + "/" + photos;
    }
}
