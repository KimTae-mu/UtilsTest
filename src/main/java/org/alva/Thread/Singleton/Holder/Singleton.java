package org.alva.Thread.Singleton.Holder;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public final class Singleton {

    private byte[] data = new byte[1024];

    private Singleton() {
    }

    //在静态内部类中持有Singleton的实例,并且可被直接初始化
    private static class Holder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.instance;
    }
}
