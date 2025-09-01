package com.wipro.user.dto;

import lombok.Data;

@Data
public class UserResponse {
    private int id;
    private String name;
    private String email;
}