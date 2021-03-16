package com.ybzbcq.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserEntity {

	private String userId;
	private LocalDateTime birthdayTime;
	private LocalDateTime graduationTime;
}