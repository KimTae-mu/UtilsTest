package org.alva.RabbitMQ.FanoutExchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import org.alva.Utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <一句话描述>,消费者
 * <详细介绍>,发布/订阅模式下的消费者1
 *
 * 一个生产者，多个消费者，每一个消费者都有自己的一个队列，生产者没有将消息直接发送到队列，
 * 而是发送到了交换机，每个队列绑定交换机，生产者发送的消息经过交换机，到达队列，实现一个消息被
 * 多个消费者获取的目的。需要注意的是，如果将消息发送到一个没有队列绑定的exchange上面，
 * 那么该消息将会丢失，这是因为在rabbitMQ中exchange不具备存储消息的能力，只有队列具备存储消息的能力。
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class Consumer1 {
    public static final String QUEUE_NAME = "fanout_queue_1";

    public static final String EXCHANGE_NAME = "fanout_exchange";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //1.获取连接
        Connection connection = ConnectionUtil.getConnection("localhost", 5672, "/", "guest", "guest");
        //2.声明信道
        Channel channel = connection.createChannel();
        //3.声明交换器
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //4.绑定队列到交换器
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);

        //5.定义队列的消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        //5.监听队列,手动返回完成状态
        channel.basicConsume(QUEUE_NAME, false, queueingConsumer);
        //6.获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[消费者1] received message : '" + message + "'");
            //休眠10毫秒
            Thread.sleep(10);
            //返回确认状态
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
