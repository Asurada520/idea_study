package com.jade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users implements Serializable {
    private static final long serialVersionUID = 9043541664656203570L;
    private String id;
    private String name;
    private String age;
}
