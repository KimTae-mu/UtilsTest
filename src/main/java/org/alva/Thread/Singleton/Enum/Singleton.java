package org.alva.Thread.Singleton.Enum;

/**
 * <一句话描述>,
 * <详细介绍>,
 * 枚举类型本身是final的,不允许被继承
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public enum Singleton {
    INSTANCE;

    private byte[] data = new byte[1024];

    Singleton(){
        System.out.println("INSTANCE will be initialized immediately");
    }

    public static void method(){
        //调用该方法则会制动使用Singleton,INSTANCE将会被实例化
    }

    public static Singleton getInstance(){
        return INSTANCE;
    }
}
