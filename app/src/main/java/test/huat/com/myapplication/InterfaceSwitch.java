package test.huat.com.myapplication;

import android.os.Handler;
import android.os.Message;

import java.util.TimerTask;


public class InterfaceSwitch extends TimerTask {
    private static int count = 1;
    Handler handler;

    public InterfaceSwitch(Handler handle) {
        this.handler = handle;
    }

    public void run() {
        while(true) {
            try {
                Message mess = new Message();
                switch(count) {
                    case 0:
                    case 4:
                        Thread.sleep(1400);break;
                    case 6:
                    case 7:
                        Thread.sleep(1200);break;

                    case 1:
                    case 3:
                        Thread.sleep(1000);break;
                    case 2:
                    case 5:
                    case 8:
                        Thread.sleep(1000*10);break;
                }
                mess.what = 1;
                mess.obj = count;
                handler.sendMessage(mess);
                count++;
                if(count==9) count = 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
