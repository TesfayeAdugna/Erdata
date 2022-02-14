package com.erdata.project.Security;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.erdata.project.Suggestion;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User extends Person implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotNull
    @Length(min=3, max = 16, message = "Username must contain between 3-16 characters")
    private String username;
    @NotNull
    @Size(min = 5, message = "Password must contain at least 5 characters")
    private String password;
    @Length(min = 10,max = 10, message = "Phone number must contain 10 digits." )
    @Digits(integer = 10, fraction = 0, message = "Phone number must be digits.")
    private String phone;
    private String role;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Suggestion>suggestionChild;

    public boolean isAdmin(){
        if (this.role == "ROLE_ADMIN") return true;
        return false;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}