package org.alva.ConcurrentBeauty.Chapter01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class SleepExample {

    //创建一个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {

            //获取独占锁
            lock.lock();
            try {
                System.out.println("child threadA is in sleep");
                TimeUnit.SECONDS.sleep(10);
//                Thread.currentThread().wait();
                System.out.println("child threadA is in awaked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //释放锁
                lock.unlock();
            }
        });

        Thread threadB = new Thread(() -> {

            //获取独占锁
            lock.lock();
            try {
                System.out.println("child threadB is in sleep");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("child threadB is in awaked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //释放锁
                lock.unlock();
            }
        });

        threadA.start();
        threadB.start();
    }
}
