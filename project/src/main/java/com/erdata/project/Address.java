package com.erdata.project;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address{
   private String houseNumber;
   private String kebele;
   private String city;
   private String region;
   private String country;
}

