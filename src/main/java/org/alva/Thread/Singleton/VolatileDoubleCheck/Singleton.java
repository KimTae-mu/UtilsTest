package org.alva.Thread.Singleton.VolatileDoubleCheck;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public final class Singleton {

    private byte[] data = new byte[1024];

    private Singleton(){}

    private volatile static Singleton instance = null;
}
