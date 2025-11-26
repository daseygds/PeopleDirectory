package com.personInfo.api.dto;

import lombok.Data;

@Data
public class PersonResponse {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String aadharCard;
    private String email;
    private String createdAt;
}
