package com.hahahey.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author hahahey
 * @date 2023-04-02 18:32
 */
public class Server {
    /**
     * connect 客户端连接成功时触发
     * accept  服务端成功接收连接时触发
     * read 数据可读入时触发
     * write 数据可写入时触发
     */
    public static void main(String[] args) throws Exception {

        //1.获取管道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.设置非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //3.绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8888));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器上，并且开始指定监听的接收事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务端已启动...");
        //6.轮询已经就绪的事件
        while (true) {
            //阻塞等待channel就绪
            selector.select();
            System.out.println("received message!!!!!!!!!!!!!!!!!!!!!!!!!!");
            //7.获取选择器中所有注册的通道中已准备好的事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            //8.开始遍历事件
            while (it.hasNext()) {
                SelectionKey key = it.next();
                //9.判断这个事件具体是啥
                if (key.isAcceptable()) {
                    System.out.println("客户端已连接");
                    //10.获取当前接入事件的客户端通道
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //11.切换成非阻塞模式
                    socketChannel.configureBlocking(false);
                    //12.将本客户端注册到选择器
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    //向客户端发送消息
                    ByteBuffer buffer = ByteBuffer.wrap("message from server ".getBytes());
                    socketChannel.write(buffer);

                    //当缓冲区至少还有一个元素时，返回 true
                    if (buffer.hasRemaining()) {
                        //添加写事件
                        key.interestOps(key.interestOps() + SelectionKey.OP_WRITE);
                        //把写的数据挂到channel上
                        key.attach(buffer);
                    }
                } else if (key.isReadable()) {
                    try {
                        SocketChannel readChannel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
                        readChannel.read(byteBuffer);
                        byteBuffer.flip();
                        System.out.println("接收到客户端数据 " + new String(byteBuffer.array()));

                    } catch (Exception e) {
                        System.out.println("客户端已退出..........");
                    } finally {
                        // 客户端发送数据过来，正常，异常关闭都会触发read事件 所以在正常关闭时候需要取消在selector上注册的channel，后续不在监听
                        key.cancel();
                    }
                } else if (key.isWritable()) {
                    ByteBuffer writeByteBuffer = (ByteBuffer) key.attachment();
                    SocketChannel channel = (SocketChannel) key.channel();
                    channel.write(writeByteBuffer);

                    if (!writeByteBuffer.hasRemaining()) {
                        System.out.println("服务器已发送消息...取消写事件");
                        key.interestOps(key.interestOps() - SelectionKey.OP_WRITE);
                        key.attach(null);
                    }

                } else {

                }
                //15.处理完毕后，移除当前事件
                //it.remove();
            }
        }

    }
}
