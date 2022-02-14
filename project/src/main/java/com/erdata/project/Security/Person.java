package com.erdata.project.Security;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String address;
    
}
