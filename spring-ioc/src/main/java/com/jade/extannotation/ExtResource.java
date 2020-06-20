package com.jade.extannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, FIELD, METHOD })
@Retention(value = RUNTIME)
public @interface ExtResource {
}
