package com.jade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class FileUploadInfoEntity implements Serializable {
    private static final long serialVersionUID = -2158557870837944363L;
    private String cuuid;
    private String title;
    private String img_name;
    private String img_url;
    private String text;
    private String create_time;
    private Integer priority;
}
