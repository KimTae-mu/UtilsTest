package org.alva.Thread.SingleThreadExecution.Noodles;

import sun.tools.jconsole.Tab;

import java.sql.SQLOutput;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class EatNoodleThread extends Thread {

    private final String name;
/*

    //左手边的餐具
    private final Tableware leftTool;

    //右手边的餐具
    private final Tableware rightTool;
*/

    private final TablewarePair tablewarePair;

    public EatNoodleThread(String name, TablewarePair tablewarePair) {
        this.name = name;
        /*this.leftTool = leftTool;
        this.rightTool = rightTool;*/
        this.tablewarePair = tablewarePair;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

   /* private void eat() {
        synchronized (leftTool) {
            System.out.println(name + " take up " + leftTool + "(left)");
            synchronized (rightTool) {
                System.out.println(name + " take up " + rightTool + "(right)");
                System.out.println(name + " is eating now.");
                System.out.println(name + " put down " + rightTool + "(right)");
            }
            System.out.println(name + " put down " + leftTool + "(left)");
        }
    }*/

    private void eat() {
        synchronized (tablewarePair) {
            System.out.println(name + " take up " + tablewarePair.getLeftTool() + "(left)");
            System.out.println(name + " take up " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " is eating now.");

            System.out.println(name + " put down " + tablewarePair.getLeftTool() + "(left)");
            System.out.println(name + " put down " + tablewarePair.getRightTool() + "(right)");

        }
    }

    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


/*        new EatNoodleThread("A", fork, knife).start();
        new EatNoodleThread("B", knife, fork).start();*/
    }
}
