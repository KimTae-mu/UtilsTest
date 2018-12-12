package org.alva.ConcurrentBeauty.Chapter01;

import java.util.concurrent.TimeUnit;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class JoinExample2 {

    public static void main(String[] args) {


        Thread threadOne = new Thread(() -> {
            System.out.println("threadOne begin run");

            for (; ; ) {

            }
        });

        final Thread mainThread = Thread.currentThread();

        Thread threadTwo = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainThread.interrupt();
        });

        threadOne.start();

        threadTwo.start();

        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread:" + e);
        }
    }
}
