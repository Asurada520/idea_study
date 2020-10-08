package com.jade.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 供应商订购信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MAppEntity {

    private long id;
    private String app_name;
    private String app_id;
    private String app_secret;
    private String is_flag;
    private String access_token;

}
