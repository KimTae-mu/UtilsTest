package org.alva.Thread.Singleton.Hungary;

/**
 * <一句话描述>,
 * 饿汉式单例模式
 * <详细介绍>,
 * final 不允许被继承
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public final class Singleton {

    //实例变量
    private byte[] data = new byte[1024];

    private static Singleton instance = new Singleton();

    //私有构造函数,不允许外部new
    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}
