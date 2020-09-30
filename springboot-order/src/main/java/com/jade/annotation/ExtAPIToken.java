package com.jade.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  接口幂等性设计 获取token
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)

public @interface ExtAPIToken {
}
