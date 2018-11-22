package org.alva.Thread.ThreadPool;

import org.alva.Thread.ThreadPool.Interface.RunnableQueue;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {

        //如果当前任务为running并且没有被中断,则其将不断地从queue中获取runnable,然后执行run方法
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (Exception e) {
                running = false;
                break;
            }
        }
    }

    /**
     * 停止当前任务,主要会在线程池的shutdown方法中使用
     * <p>
     * 主要用于停止当前线程,一般在线程池销毁和线程数量维护的时候回使用到
     */
    public void stop() {
        this.running = false;
    }
}
