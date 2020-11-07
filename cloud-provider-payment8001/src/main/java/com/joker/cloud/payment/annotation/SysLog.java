package com.joker.cloud.payment.annotation;

import java.lang.annotation.*;

/** 自定义注解实现日志
 * @Author:Tom-joker
 * @Date:2020/11/3
 * @version:1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface SysLog {

    String description() default "";
}
