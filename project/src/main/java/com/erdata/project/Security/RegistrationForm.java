package com.erdata.project.Security;


import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm{
    private String username;
    private String password;
    private String phone;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String address;

    User toUser(PasswordEncoder encoder) {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(encoder.encode(this.password));
        user.setPhone(this.phone);
        user.setGender(this.gender);
        user.setAddress(this.address);
        user.setMiddleName(this.middleName);
        user.setLastName(this.lastName);
        user.setFirstName(this.firstName);
        return user;
    }
}