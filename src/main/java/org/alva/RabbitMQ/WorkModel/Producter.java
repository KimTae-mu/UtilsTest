package org.alva.RabbitMQ.WorkModel;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.alva.Utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <一句话描述>,生产者
 * <详细介绍>,Work模式下的生产者
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class Producter {
    public static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //1.获取连接
        Connection connection = ConnectionUtil.getConnection("localhost", 5672, "/", "guest", "guest");
        //2.声明信道
        Channel channel = connection.createChannel();
        //3.声明(创建)队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //4.定义消息内容,发布多条消息
        for (int i = 0; i < 10; i++) {
            String message = "hello rabbitmq " + i;
            //5.发布消息
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[x] send message is '" + message + "'");
            //6.模拟发送消息延时,便于展示多个消费者竞争接受消息
            Thread.sleep(i * 10);
        }
        //7.关闭信道
        channel.close();
        //8.关闭连接
        connection.close();
    }
}
