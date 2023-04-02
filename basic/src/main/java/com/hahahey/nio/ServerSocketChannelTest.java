package com.hahahey.nio;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author hahahey
 * @date 2023-03-29 22:28
 */
public class ServerSocketChannelTest {
    public static void main(String[] args) throws Exception{

        //创建ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress( 7777));

        //设置非阻塞模式
        ssc.configureBlocking(false);

        while (true){
            System.out.println("waitting for connect");
            //没有连接会返回null
            SocketChannel socketChannel = ssc.accept();

            if(socketChannel == null){
                System.out.println("没有连接");
                TimeUnit.SECONDS.sleep(2);
            }else{ //说明有连接
                System.out.println(socketChannel.getRemoteAddress());
            }



        }

    }
}
