package com.starpine.drillandroid.utils;

import android.app.Activity;
import android.view.View;

import com.starpine.drillandroid.annotation.InputId;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 描述：
 *
 * @Name： DrillAndroid
 * @Description：
 * @Author： liaosf
 * @Date： 2022/11/1 18:34
 */
public class InjectionUtils {

    public static void injectionView(Activity activity)  {
        //获取类的字节码对象
        Class<? extends Activity> activityClass = activity.getClass();
        //获取类的所有成员属性
        Field[] declaredFields = activityClass.getDeclaredFields();
        for (Field field : declaredFields) {
            //判断属性是否存在相关注解
            if (field.isAnnotationPresent(InputId.class)) {
                InputId annotation = field.getAnnotation(InputId.class);
                int value = annotation.value();

                try {
                    //获取view对象两种方式
                    //1.通过activity直接获取
//                    View view = activity.findViewById(value);
                    //2.通过反射获取方法后
                    Method findViewById = activityClass.getMethod("findViewById", int.class);
                    Object view = findViewById.invoke(activity, value);
                    //设置访问权限，允许操作private的属性
                    field.setAccessible(true);
                    //通过反射赋值
                    field.set(activity,view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
