package com.erdata.project;

import java.util.Date;

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
public class Suggestion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date registered_Date = new Date(System.currentTimeMillis());
    @NotEmpty(message="child name is required")
    @Length(message="name must be between 3 and 16 characters")
    private String childname;
    @NotEmpty(message="Gender is required")
    private String gender;
    @NotEmpty(message="birth date is required")
    private String birthdate;
    @NotEmpty(message="atleast one sentence information  is required")
    @Length(min=15, max = 200, message = "write description with 15 - 200 characters")
    private String description;
}
