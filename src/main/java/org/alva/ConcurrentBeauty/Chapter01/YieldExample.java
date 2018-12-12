package org.alva.ConcurrentBeauty.Chapter01;


/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class YieldExample implements Runnable {

    YieldExample() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //当i=0时,让出CPU执行权,放弃时间片,进行下一轮调度
            if (i % 5 == 0) {
                System.out.println(Thread.currentThread() + "yield cpu...");

                //当前线程让出CPU执行权,放弃时间片,进行下一轮调度
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread() + " is over");
    }

    public static void main(String[] args) {
        new YieldExample();
        new YieldExample();
        new YieldExample();
    }
}
