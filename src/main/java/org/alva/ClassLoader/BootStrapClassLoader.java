package org.alva.ClassLoader;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class BootStrapClassLoader {
    public static void main(String[] args) {
        System.out.println("Bootstrap:"+String.class.getClassLoader());

        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
