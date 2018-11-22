package org.alva.Thrift.java.service.client;

import org.alva.Thrift.java.service.demo.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class HelloServiceClient {
    public static void main(String[] args) {
        try {
            //设置调用的服务地址为本地 端口为7911
            TTransport transport = new TSocket("localhost",7911);
            transport.open();
            //设置传输协议为TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);

            //调用服务的helloVoid方法
            client.helloVoid();
            transport.close();
        }catch (TTransportException e){
            e.printStackTrace();
        }catch (TException e){
            e.printStackTrace();
        }
    }
}
