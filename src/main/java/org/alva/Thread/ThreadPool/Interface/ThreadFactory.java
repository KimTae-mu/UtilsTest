package org.alva.Thread.ThreadPool.Interface;

/**
 * <一句话描述>,
 * 创建线程的工厂
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
@FunctionalInterface
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
