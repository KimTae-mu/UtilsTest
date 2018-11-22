package org.alva.Thread.BooleanLock;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public interface Lock {

    void lock() throws InterruptedException;

    void lock(Long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockThreads();

}
