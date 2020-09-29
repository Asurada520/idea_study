package com.jade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.io.Serializable;

/**
 * 订货单实体类
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IndentInfoEntity implements Serializable {
    private static final long serialVersionUID = 1162169625779763354L;
    private String id;
    private String indent_code;
    private String indent_desc;
}
