package org.alva.Thrift.java.service.server;

import org.alva.Thrift.java.service.demo.Hello;
import org.alva.Thrift.java.service.impl.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class HelloServiceServer {
    public static void main(String[] args) {
        try {
            //设置服务端口为7911
            TServerSocket serverSocket = new TServerSocket(7911);
            //设置协议工厂为TBinaryProtocol.Factory
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
            //关联处理器与Hello服务的实现
            TProcessor processor = new Hello.Processor<>(new HelloServiceImpl());
            TThreadPoolServer.Args args1 = new TThreadPoolServer.Args(serverSocket);
            args1.processor(processor);
            args1.protocolFactory(proFactory);
            TServer server = new TThreadPoolServer(args1);
            System.out.println("Start server on port 7911");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}