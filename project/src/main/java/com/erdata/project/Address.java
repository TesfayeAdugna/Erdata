package com.erdata.project;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address{
   private String city;
   private String kebele;
   private String houseNumber;
   private String region;
   private String country;
}

