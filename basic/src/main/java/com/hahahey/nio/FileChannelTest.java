package com.hahahey.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hahahey
 * @date 2023-03-29 21:41
 */
public class FileChannelTest {
    public static void main(String[] args) throws Exception {

        //读取文件
         readFile();


        //写入文件
        //writeFile();


    }

    private static void writeFile() throws IOException {
        //创建 fileChannel
        RandomAccessFile randomAccessFile = new RandomAccessFile("F:\\aaaw.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();


        //创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        byteBuffer.clear();

        String data = "hello worldaaa";
        //将内容放入到buffer中
        byteBuffer.put(data.getBytes());
        byteBuffer.flip();

        //
        while (byteBuffer.hasRemaining()) {
            channel.write(byteBuffer);
        }

        channel.close();
    }

    private static void readFile() throws IOException {
        //创建 fileChannel
        RandomAccessFile randomAccessFile = new RandomAccessFile("F:\\aaa.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();

        //创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(12);

        //读取数据到buffer中
        int read = channel.read(byteBuffer);

        while (read != -1) {
            System.out.println("读取了 " + read + " 字节");

            //转为读模式
            byteBuffer.flip();

            //读取buffer中的数据
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }
            //读取完以后将buffer清空
            byteBuffer.clear();
            read = channel.read(byteBuffer);
        }
        channel.close();
    }
}
