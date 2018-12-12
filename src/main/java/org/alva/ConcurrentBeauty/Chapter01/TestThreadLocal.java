package org.alva.ConcurrentBeauty.Chapter01;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class TestThreadLocal {

//    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();


    public static void main(String[] args) {
        //设置线程变量
        threadLocal.set("hello world");

        //启动子线程
        Thread thread = new Thread(() -> {
            System.out.println("thread:" + threadLocal.get());
        });

        thread.start();

        System.out.println("main:" + threadLocal.get());
    }
}
