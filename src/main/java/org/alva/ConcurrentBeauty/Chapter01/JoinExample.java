package org.alva.ConcurrentBeauty.Chapter01;

import java.util.concurrent.TimeUnit;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class JoinExample {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("child threadOne over");
        });

        Thread threadTwo = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("child threadOne over");
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over");

        threadOne.join();
        threadTwo.join();

        System.out.println("all child thread over");
    }
}
