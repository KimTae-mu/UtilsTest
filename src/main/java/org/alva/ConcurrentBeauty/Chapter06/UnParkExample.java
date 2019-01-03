package org.alva.ConcurrentBeauty.Chapter06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * <一句话描述>,
 * <详细介绍>,
 * unpark,如果参数thread线程没有持有thread与LockSupport类关联的许可证,则让thread持有
 * 如果thread之前因调用park()而被挂起,则调用unpark后,该线程会被唤醒
 * 如果thread之前没有调用park,则调用unpark方法后,再调用park方法,其会立即返回
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class UnParkExample {

    public static void main(String[] args) {
        System.out.println("begin park!");

        //使当前线程获取到许可证
        LockSupport.unpark(Thread.currentThread());

        LockSupport.park();

        System.out.println("end park!");
    }
}
