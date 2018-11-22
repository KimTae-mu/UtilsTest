package org.alva.Thread;

import java.util.stream.IntStream;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ThreadYield {
    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(ThreadYield::create)
                .forEach(Thread::start);
    }

    private static Thread create(int index) {
        return new Thread(() -> {
            //注释部分
            if (index == 0) {
//                Thread.yield();
                System.out.println(index);
            }
        });
    }
}
