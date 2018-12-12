package org.alva.ConcurrentBeauty.Chapter01;

import java.util.concurrent.TimeUnit;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class InterruptedExample {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(() -> {
            try {
                System.out.println("threadOne begin sleep for 2000 seconds");
                TimeUnit.SECONDS.sleep(2000);
                System.out.println("threadOne awaking");
            } catch (InterruptedException e) {
                System.out.println("threadOne is interrupted while sleeping");
                return;
            }
            System.out.println("threadOne-leaving normally");
        });

        threadOne.start();

        TimeUnit.SECONDS.sleep(1);

        threadOne.interrupt();

        threadOne.join();

        System.out.println("main thread is over");
    }

/*    public static void test() {
        try {
            int i = 9 / 0;
        } catch (Exception e) {
            System.out.println("0");
            return;
        }
        System.out.println("hello");
    }

    public static void main(String[] args) {
        test();
    }*/
}
