package org.alva.ClassLoader;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ClassInit {

    static {
        try {
            System.out.println("The ClassInit static code block will be invoke.");
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntStream.range(0,5).forEach(i -> new Thread(ClassInit::new));
    }
}
