package org.alva.ClassLoader.CustomClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class BrokerDelegateClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //声明一个MyClassLoader
        BrokerDelegateClassLoader classLoader = new BrokerDelegateClassLoader();

        //使用MyClassLoader加载HelloWorld
        Class<?> aClass = classLoader.loadClass("org.alva.ClassLoader.SimpleClass");

        System.out.println(classLoader.getParent());

        aClass.newInstance();
    }

}
