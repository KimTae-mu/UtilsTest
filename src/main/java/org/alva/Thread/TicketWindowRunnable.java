package org.alva.Thread;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class TicketWindowRunnable implements Runnable {

    private int index;
    private static final int MAX= 500;
    private static final Object MUTEX = new Object();

    @Override
    public void run() {
        synchronized (MUTEX){
            while (index <= MAX){
                System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final TicketWindowRunnable task = new TicketWindowRunnable();

        Thread windowThread1 = new Thread(task,"一号窗口");
        Thread windowThread2 = new Thread(task,"二号窗口");
        Thread windowThread3 = new Thread(task,"三号窗口");
        Thread windowThread4 = new Thread(task,"四号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
        windowThread4.start();


    }
}
