package com.erdata.project;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Embeddable
public class Address{
   private String houseNumber;
  @NotBlank(message = "Kebele must not be Null.")
   private String kebele;
  @NotBlank(message = "City must not be Null.")
   private String city;
  @NotBlank(message = "Region must not be Null.")
   private String region;
  @NotBlank(message = "Country must not be Null.")
   private String country;
}

