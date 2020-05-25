package com.ybzbcq.test;

import com.ybzbcq.annotation.AddAnnotation;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 反射获取方法上的注解信息
 */
public class AnotationTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> clazz = Class.forName("com.ybzbcq.entity.User");
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            AddAnnotation annotation = method.getDeclaredAnnotation(AddAnnotation.class);

            if (annotation == null) {
                continue;
            }

            int userId = annotation.userId();
            String userName = annotation.userName();
            String[] arrays = annotation.arrays();
            System.out.println("userId=" + userId + ", userName=" + userName + ", arrays=" + Arrays.toString(arrays));

        }


    }
}
