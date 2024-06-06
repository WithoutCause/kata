package me.sjl.proxy.jdk.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Rest {

    /**
     * 请求地址
     * @return
     */
    String value();

    /**
     * 请求方法
     * @return
     */
    String method() default "GET";

    /**
     * 请求参数
     * @return
     */
    String[] params() default {};

    /**
     * 请求头
     * @return
     */
    String[] headers() default {};
}
