package org.alva.Thread.Singleton.Enum;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class SingletonHolder {

    private byte[] data = new byte[1024];

    private SingletonHolder() {
    }

    private enum EnumHolder {
        INSTANCE;
        private SingletonHolder instance;

        EnumHolder() {
            this.instance = new SingletonHolder();
        }

        private SingletonHolder getSingleton() {
            return instance;
        }
    }

    public static SingletonHolder getInstance() {
        return EnumHolder.INSTANCE.getSingleton();
    }
}
