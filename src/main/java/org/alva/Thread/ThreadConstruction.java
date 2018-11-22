package org.alva.Thread;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ThreadConstruction {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Please enter the stack size");
            System.exit(1);
        }

        ThreadGroup threadGroup = new ThreadGroup("textGroup");

        Runnable runnable = new Runnable() {

            final int MAX = Integer.MAX_VALUE;

            @Override
            public void run() {
                int i = 0;
                recurse(i);
            }

            private void recurse(int i) {
                System.out.println(i);

                if (i < MAX) {
                    recurse(i + 1);
                }
            }
        };
        Thread thread = new Thread(threadGroup, runnable, "Text", Integer.parseInt(args[0]));

        thread.start();
    }
}
