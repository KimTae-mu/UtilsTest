package org.alva.ConcurrentBeauty.Chapter01;

import java.util.concurrent.TimeUnit;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class NotifyExample {

    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {

        //创建线程
        Thread threadA = new Thread(() -> {

            //获取resourceA共享资源的监视器锁
            synchronized (resourceA) {

                System.out.println("threadA get resourceA lock");

                try {
                    System.out.println("threadA begin wait");
                    resourceA.wait();
                    System.out.println("threadA end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(() -> {

            //获取resourceA共享资源的监视器锁
            synchronized (resourceA) {

                System.out.println("threadB get resourceA lock");

                try {
                    System.out.println("threadB begin wait");
                    resourceA.wait();
                    System.out.println("threadB end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("threadC begin notify");
                resourceA.notifyAll();
            }
        });

        //启动线程
        threadA.start();
        threadB.start();

        TimeUnit.SECONDS.sleep(1);
        threadC.start();

        //等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
