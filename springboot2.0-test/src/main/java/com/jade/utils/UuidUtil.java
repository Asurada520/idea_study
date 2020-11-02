package com.jade.utils;

import java.util.UUID;

public class UuidUtil {

	public static String get18UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "").substring(0, 18);
		return uuid;
	}	
}

