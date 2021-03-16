package com.ybzbcq.controller;


import com.ybzbcq.entity.UserDto;
import com.ybzbcq.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
public class DateTestController {

    @PostMapping(value = "/date1")
    public String date1(@RequestBody UserDto userDto) {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDto.getUserId());
        userEntity.setBirthdayTime(LocalDateTime.parse(userDto.getBirthdayTime(), FORMATTER));
        userEntity.setGraduationTime(LocalDateTime.parse(userDto.getGraduationTime(), FORMATTER));
        log.info(userEntity.toString());
        return "success";
    }
}
