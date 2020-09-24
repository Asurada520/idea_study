package com.jade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TestReqEntity implements Serializable {
    private static final long serialVersionUID = -9036536323670458047L;
    private String username;
    private String password;
    private String token;
}
