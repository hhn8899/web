package com.dzt.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            System.out.println("对象注入参数之前:" + bean);
            BeanUtils.populate(bean, value);
            System.out.println("对象注入参数之后:" + bean);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串数字转为int类型的数字
     * @param strInt 字符串值
     * @param defaultValue
     * @return
     */
    public static int psrseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
