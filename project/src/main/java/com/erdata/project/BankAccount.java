package com.erdata.project;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BankAccount{
    private String bankName;
    private String accountNumber;
    // private String qrCodePhoto;
}
