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
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //声明一个MyClassLoader
        MyClassLoader classLoader = new MyClassLoader("/Users/admin/coding/Java/MyClassLoader", null);

        //使用MyClassLoader加载HelloWorld
        Class<?> aClass = classLoader.loadClass("org.alva.ClassLoader.SimpleClass");

        System.out.println(aClass.getClassLoader());
        System.out.println(classLoader.getParent());

        /*//注释
        Object helloWorld = aClass.newInstance();
        System.out.println(helloWorld);

        Method welcomeMethod = aClass.getMethod("welcome");

        String result = (String) welcomeMethod.invoke(helloWorld);

        System.out.println("Result:" + result);*/
    }
}
