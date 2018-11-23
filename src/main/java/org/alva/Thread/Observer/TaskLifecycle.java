package org.alva.Thread.Observer;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public interface TaskLifecycle<T> {

    //任务启动时会触发onStart方法
    void onStart(Thread thread);

    //任务正在运行时会触发onRunning方法
    void onRunning(Thread thread);

    //任务运行结束时会触发onFinish方法,其中result是任务执行结束后的结果
    void onFinish(Thread thread,T result);

    //任务执行报错时会触发onError方法
    void onError(Thread thread,Exception e);

    /**
     * TaskLifecycle接口定义了在任务执行的生命周期中会被触发的接口,其中EmptyLifecycle是一个空的实现,主要是为了让使用者保持对Thread类的使用习惯
     * @param <T>
     */
    //声明周期接口的空实现(Adapter)
    class EmptyLifecycle<T> implements TaskLifecycle<T>{

        @Override
        public void onStart(Thread thread) {

        }

        @Override
        public void onRunning(Thread thread) {

        }

        @Override
        public void onFinish(Thread thread, T result) {

        }

        @Override
        public void onError(Thread thread, Exception e) {

        }
    }
}
