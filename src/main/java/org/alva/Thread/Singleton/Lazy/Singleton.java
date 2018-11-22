package org.alva.Thread.Singleton.Lazy;

/**
 * <一句话描述>,
 * 懒汉式单例模式
 *
 * <详细介绍>,
 * final不允许被继承
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public final class Singleton {

    private byte[] data = new byte[1024];

    private static Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance(){
        if(null == instance){
            instance = new Singleton();
        }
        return instance;
    }
}
