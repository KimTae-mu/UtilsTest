package org.alva.ConcurrentBeauty.Chapter06;

import java.util.concurrent.locks.LockSupport;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ParkExample {

    public static void main(String[] args) {
        System.out.println("begin park!");

        LockSupport.park();

        System.out.println("end park!");
    }
}
