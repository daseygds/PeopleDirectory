package com.personInfo.api.dto;

import lombok.Data;

@Data
public class PersonRequest {
    private String name;
    private String address;
    private String phoneNumber;
    private String aadharCard;
    private String email;
}
