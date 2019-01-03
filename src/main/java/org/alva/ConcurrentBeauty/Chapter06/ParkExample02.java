package org.alva.ConcurrentBeauty.Chapter06;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ParkExample02 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("child thread begin park!");

            LockSupport.park();

            System.out.println("child thread unpark!");
        });

        thread.start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("main thread begin unpark!");

        LockSupport.unpark(thread);
    }
}
