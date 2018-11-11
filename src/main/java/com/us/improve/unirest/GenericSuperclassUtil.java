package com.us.improve.unirest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author liangliang
 * @date 2018/11/11 10:53 PM
 */
public class GenericSuperclassUtil {

    public static Class<?> getActualTypeArgument(Class<?> clazz) {
        Class<?> entityClass = null;
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass)
                    .getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                entityClass = (Class<?>) actualTypeArguments[0];
            }
        }

        return entityClass;
    }

}
