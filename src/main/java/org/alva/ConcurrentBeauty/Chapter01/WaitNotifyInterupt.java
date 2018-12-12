package org.alva.ConcurrentBeauty.Chapter01;

import java.util.concurrent.TimeUnit;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class WaitNotifyInterupt {

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {

        //创建线程
        Thread threadA = new Thread(() -> {
            try {
                System.out.println("---begin---");

                //阻塞当前线程
                synchronized (obj) {
                    obj.wait();
                }
                System.out.println("---end---");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("---begin interrupt threadA---");
        threadA.interrupt();
        System.out.println("---end interrupt threadA---");
    }
}
