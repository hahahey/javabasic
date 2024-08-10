package com.hahahey.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author hahahey
 * @date 2023-04-02 18:32
 */
public class Client {
    public static void main(String[] args) throws Exception {

        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(8888));
        socketChannel.configureBlocking(false);
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.print("请输入:");
//            String msg = scanner.nextLine();
//            buffer.put(msg.getBytes());
//            buffer.flip();
//            socketChannel.write(buffer);
//            buffer.clear();
//
//            System.out.println("-----");
//        }


        socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ);



        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                System.out.println("------------------");
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isConnectable()) {

                    //System.out.println(socketChannel.finishConnect());


                }else if(selectionKey.isReadable()){
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(100);
                    byteBuffer.clear();
                    channel.read(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array()));
                }
                //iterator.remove();
            }

        }


    }
}
