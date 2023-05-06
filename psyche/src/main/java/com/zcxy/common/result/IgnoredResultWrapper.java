package com.zcxy.common.result;


import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface IgnoredResultWrapper {
}
