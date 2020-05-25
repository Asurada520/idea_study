package com.ybzbcq.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
