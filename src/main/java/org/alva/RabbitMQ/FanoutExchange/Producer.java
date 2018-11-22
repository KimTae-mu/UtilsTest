package org.alva.RabbitMQ.FanoutExchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.alva.Utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <一句话描述>,发布/订阅模式下的生产者
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class Producer {
    private final static String EXCHANGE_NAME = "fanout_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.获取连接
        Connection connection = ConnectionUtil.getConnection("localhost", 5674, "/", "guest", "guest");
        //2.声明信道
        Channel channel = connection.createChannel();
        //3.声明交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        //4.定义消息内容
        String message = "hello rabbitmq";
        //5.发布消息
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println("[x] send'" + message + "'");
        //6.关闭通道和连接
        channel.close();
        connection.close();

    }
}
