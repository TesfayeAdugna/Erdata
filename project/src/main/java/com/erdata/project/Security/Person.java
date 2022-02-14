package com.erdata.project.Security;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.erdata.project.Address;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {
    @NotNull
    @Length(min = 3, max = 16, message = "First name must contain between 3-16 characters")
    private String firstName;

    private String middleName;
    @NotNull
    @Length(min = 3, max = 16, message = "Last name must contain between 3-16 characters")
    private String lastName;
    @NotBlank(message = "Please select gender")
    private String gender;
    @Embedded
    private Address address;
    
}
