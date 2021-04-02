package com.hahahey.Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class SocketThread implements Runnable {

    private final Socket socket;

    @Override
    public void run() {
        try {

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info ;
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("message   " + info);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    public void send(){
        System.out.println("this is the sed message !!!");
    }

}
