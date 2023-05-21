package com.zsw.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限校验注解
 */
// @Target表明注解的作用范围,这里表示作用于方法上
@Target(ElementType.METHOD)
// @Retention表明注解的生命周期,这里是运行时使用
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

    /**
     * 满足任何一个角色即可
     * @return
     */
    String[] anyRole() default "";

    /**
     * 必须有某个角色
     * @return
     */
    String mustRole() default "";
}
