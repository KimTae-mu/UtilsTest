package org.alva.ConcurrentBeauty.Chapter01;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ThreadLocalExample {

    static void print(String str) {
        //1.1打印当前县城本地内存中localVariable变量的值
        System.out.println(str + ":" + localVariable.get());
        //1.2清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    //创建ThreadLocal变量
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        //创建线程
        Thread threadOne = new Thread(() -> {
            //设置线程One中本地变量localVariable的值
            localVariable.set("threadOne local Variable");
            //调用打印函数
            print("threadOne");
            //打印本地变量值
            System.out.println("threadOne remove after" + ":" + localVariable.get());
        });

        //创建线程
        Thread threadTwo = new Thread(() -> {
            //设置线程One中本地变量localVariable的值
            localVariable.set("threadTwo local Variable");
            //调用打印函数
            print("threadTwo");
            //打印本地变量值
            System.out.println("threadTwo remove after" + ":" + localVariable.get());
        });

        threadOne.start();
        threadTwo.start();
    }
}
