package org.alva.Thread;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class DeamonThread {

    public static void main(String[] args) throws InterruptedException {
        //main线程开始
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //setDaemon()只在线程启动之前才能生效
        thread.setDaemon(true); //将thread设置为守护线程

        thread.start();
        Thread.sleep(2_000L);
        System.out.println("Main thread finished lifecycle");
        //main线程结束
    }
}
