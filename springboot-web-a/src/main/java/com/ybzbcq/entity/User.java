package com.ybzbcq.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 4270902405748231010L;
    private String username;
    private String gender;
}
