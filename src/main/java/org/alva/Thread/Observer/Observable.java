package org.alva.Thread.Observer;

/**
 * <一句话描述>,
 * <详细介绍>,
 * 该接口主要是暴露给调用者使用的,其中四个枚举类型分别代表了当前任务执行声明周期的各个阶段
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public interface Observable {

    //任务生命周期的枚举类型
    enum Cycle {
        STARTED, RUNNING, DONE, ERROR
    }

    //获取当前任务的生命周期状态
    Cycle getCycle();

    //定义启动线程的方法,主要作用是为了屏蔽Thread的其他方法
    void start();

    //定义线程的打断方法,作用于start方法一样,也是为了屏蔽Thread的其他方法
    void interrupt();
}
