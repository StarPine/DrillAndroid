package com.starpine.drillandroid.annotation;

import androidx.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述：
 *
 * @Name： DrillAndroid
 * @Description：
 * @Author： liaosf
 * @Date： 2022/11/1 18:30
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InputId {
    @IdRes int value();
}
