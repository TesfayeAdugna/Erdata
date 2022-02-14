package com.erdata.project.Security;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

import com.erdata.project.Address;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {
    @NotEmpty(message="first name is required")
    @Length(min = 3,max = 16, message = "name must be between 3-16 character")
    private String firstName;
    private String middleName;
    @NotEmpty(message="lastname name is required")
    @Length(min = 3,max = 16, message = "name must be between 3-16 character")
    private String lastName;
    @NotEmpty(message="Gender is required")
    private String gender;
    @Embedded
    private Address address;
    
}
