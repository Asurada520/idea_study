package com.jade.entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestReqEntity implements Serializable {
    private static final long serialVersionUID = -9036536323670458047L;
    private String username;
    private String password;
    private String token;
}
