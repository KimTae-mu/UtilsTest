package org.alva.ConcurrentBeauty.Chapter01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class Callertask implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("in call");
        return "hello";
    }

    public static void main(String[] args) throws InterruptedException {
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new Callertask());

        //启动线程
        new Thread(futureTask).start();

        System.out.println("world");
        try {
            //等待任务执行完毕,并返回结果
            String result = futureTask.get();

            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
