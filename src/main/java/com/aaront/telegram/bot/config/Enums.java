package com.aaront.telegram.bot.config;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

import static com.google.common.collect.Maps.newLinkedHashMap;
import static com.google.common.collect.Maps.newLinkedHashMapWithExpectedSize;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptor;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;

public class Enums {

    /**
     * 获取枚举中指定属性的值
     *
     * @param enumCls 枚举类型
     * @param prop    Bean属性名
     * @return (枚举值, 指定属性的值)
     */
    public static Map<Enum<?>, Object> getEnumAndValue(Class<?> enumCls, String prop) {

        Object[] enumValues = enumCls.getEnumConstants();
        if (isEmpty(enumValues)) {
            return newLinkedHashMap();
        }
        Map<Enum<?>, Object> result = newLinkedHashMapWithExpectedSize(enumValues.length * 2);
        try {
            for (Object enumValue : enumValues) {
                PropertyDescriptor pd = getPropertyDescriptor(enumValue, prop);
                if (pd == null || pd.getReadMethod() == null) {
                    continue;
                }
                result.put((Enum<?>) enumValue, pd.getReadMethod().invoke(enumValue));
            }
        } catch (Exception e) {
            // ignore
        }
        return result;
    }

    /**
     * 匹配枚举集合中指定的Bean属性, 返回该枚举值
     *
     * @param prop      Bean属性名
     * @param propValue Bean属性值
     */
    public static <T extends Enum> Optional<T> getEnum(Class<T> enumCls, String prop, String propValue) {

        T[] enumValues = enumCls.getEnumConstants();
        if (isEmpty(enumValues)) {
            return empty();
        }
        try {
            for (T enumValue : enumValues) {
                PropertyDescriptor pd = getPropertyDescriptor(enumValue, prop);
                if (pd == null || pd.getReadMethod() == null) {
                    continue;
                }
                Method m = pd.getReadMethod();
                m.setAccessible(true);
                if (propValue.equals(m.invoke(enumValue).toString())) {
                    return of(enumValue);
                }
            }
        } catch (Exception e) {
            // ignore
        }
        return empty();
    }

    /**
     * 匹配枚举集合中指定的Bean属性, 返回该枚举值
     * (propValue使用Object)
     *
     * @param prop      Bean属性名
     * @param propValue Bean属性值
     */
    public static <T extends Enum> Optional<T> getEnum(Class<T> enumCls, String prop, Object propValue) {

        T[] enumValues = enumCls.getEnumConstants();
        if (isEmpty(enumValues)) {
            return empty();
        }
        try {
            for (T enumValue : enumValues) {
                PropertyDescriptor pd = getPropertyDescriptor(enumValue, prop);
                if (pd == null || pd.getReadMethod() == null) {
                    continue;
                }
                if (propValue.equals(pd.getReadMethod().invoke(enumValue))) {
                    return of(enumValue);
                }
            }
        } catch (Exception e) {
            // ignore
        }
        return empty();
    }
}