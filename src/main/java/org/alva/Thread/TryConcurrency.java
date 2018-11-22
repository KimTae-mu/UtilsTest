package org.alva.Thread;


import java.util.concurrent.TimeUnit;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class TryConcurrency {
    public static void main(String[] args) {
        new Thread(TryConcurrency::enjoyMusic).start();
        browseNews();
    }

    private static void browseNews() {
        for (; ; ) {
            System.out.println("Uh-huh, the good news. ");
            sleep(1);
        }
    }

    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("Uh-huh, the nice music. ");
            sleep(1);
        }
    }

    private static void sleep(int times) {
        try {
            TimeUnit.SECONDS.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
