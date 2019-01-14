package test.huat.com.myapplication;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Monitor implements Runnable {
    private static final String TAG = "Monitor";
    private Handler handler;
    DatagramSocket ds=null;

    public Monitor(Handler handler) {
        this.handler = handler;
    }

    byte[] bt = new byte[1024];


    DatagramPacket dp;//接收消息


    @Override
    public void run() {
        try {
            ds = new DatagramSocket(5556);//使用DatagramSocket发送、接收数据
            dp = new DatagramPacket(bt, bt.length);//接收消息;
            Log.d(TAG, "run: "+"123");
            while (true) {
                ds.receive(dp);
                String data = new String(dp.getData(), 0, dp.getLength());
                Log.d(TAG, "run: "+data);


                Message mess = new Message();
                ReceiveMess rm = new ReceiveMess();

                rm.setNews(data);
                mess.obj = rm;
                mess.what = 1;
                handler.sendMessage(mess);

              }
//            }

        }  catch(IOException e){
            e.printStackTrace();
        }
    //    ds.close();

    }
}
