package org.alva.ConcurrentBeauty.Chapter02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * <一句话描述>,
 * <p>
 * Unsafe类是rt.jar包提供的,rt.jar包里面的类是使用Bootstrap类加载器加载的,
 * 而我们启动的main函数所在的类是使用APPClassLoader加载的,所以在main函数里面
 * 加载Unsafe类时,根据委托机制,会委托Bootstrap去加载Unsafe类
 * 如果没有限制,我们的应用程序就可以随意使用Unsafe做事情,而Unsafe类
 * 可以直接操作内存,这是不安全的,所以JDK特意做了这个限制,不让开发人员在正规渠道使用
 * Unsafe类,,而是在rt.jar包里面的核心类中使用Unsafe功能
 * <p>
 * <详细介绍>,
 * <p>
 * 使用反射实例化Unsafe类
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class UnsafeExample {

    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            //使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            //设置为可存取
            field.setAccessible(true);

            //获取该变量的值
            unsafe = (Unsafe) field.get(null);

            //获取state在TestUnsafe中的偏移量
            stateOffset = unsafe.objectFieldOffset(UnsafeExample.class.getDeclaredField("state"));

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        UnsafeExample test = new UnsafeExample();
        boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
