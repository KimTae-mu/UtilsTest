package org.alva.Thread.BooleanLock;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class BooleanLockTest {

    private final Lock lock = new BooleanLock();

    public void syncMethod() throws InterruptedException {
        lock.lock();
        try {
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BooleanLockTest blt = new BooleanLockTest();

        //定义一个线程并且启动
        IntStream.range(0, 10)
                .mapToObj(i -> new Thread(() -> {
                    try {
                        blt.syncMethod();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }))
                .forEach(Thread::start);
    }
}
