package test.huat.com.myapplication;

import android.os.Handler;
import android.os.Message;
import android.util.Log;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by fangju on 2018/12/20
 */
public class MyThread extends Thread {
    private static final String TAG = "MyThread";
    private int port = 3000;
    private DatagramSocket dSocket = null;
    private DatagramPacket dPacket = null;
    private byte[] buffer = null;//数据报大小
    private String receString;//接收到的数据
    private Handler handler;

    public MyThread(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            buffer = new byte[1024];
            dSocket = new DatagramSocket(5556);
            Log.d(TAG, "run: "+"kaiqi");
            while (true){
                dPacket = new DatagramPacket(buffer,buffer.length);
                dSocket.receive(dPacket);
                receString = new String(dPacket.getData());
                Log.d(TAG, "run: "+receString);
//                send(receString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void send(String message){
        Message msg = handler.obtainMessage();
        msg.obj = message;
        handler.sendMessage(msg);
    }
}
