package org.alva.Test;

import org.junit.Test;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ThreadTest {
    private class Say implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("hello ---- +:" + i);
            }
        }
    }

    @Test
    public void TestThread(){
        Say say = new Say();
        for (int i = 0; i < 100; i++) {
            System.out.println("world ---- +:" + i);
        }
        new Thread(say).start();

    }
}

