package com.erdata.project;

import java.util.Date;

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
public class Suggestion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date registered_Date = new Date(System.currentTimeMillis());
    @NotEmpty(message="this value is required")
    private String childname;
    private String gender;
    @NotEmpty(message="this value is required")
    private String birthdate;
    @NotEmpty(message="this value is required")
    private String description;
}
