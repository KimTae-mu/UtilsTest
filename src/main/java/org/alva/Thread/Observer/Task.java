package org.alva.Thread.Observer;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
@FunctionalInterface
public interface Task<T> {

    //任务执行接口,该接口允许有返回值
    T call();
}
