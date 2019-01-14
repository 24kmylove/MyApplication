package test.huat.com.myapplication;


import android.app.Activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends Activity {
    private ImageView iv_flower;
    private ImageView iv;
    private AnimationDrawable animationDrawable;
    private Thread th;String js;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.zero_activity);
//        iv_flower = (ImageView) findViewById(R.id.iv_zero);

        setContentView(R.layout.carfault);
        iv = findViewById(R.id.carfault);
        iv.setImageResource(R.drawable.gif01);

//        animationDrawable = (AnimationDrawable) iv_flower.getBackground();
//        animationDrawable.start();
//
//        th = new Thread(new Monitor(handler));
//
        Thread thread = new Thread(new Monitor(handler));
//        th.start();
//        //thread.start();
//            MyThread thread = new MyThread(handler);
            thread.start();
    }


    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                ReceiveMess mess = (ReceiveMess) msg.obj;
                try {
                    JSONArray ja = new JSONArray(mess.getNews());
                    JSONObject jo = ja.getJSONObject(1);
                    System.out.println(jo);
                    js = jo.getString("js");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                switch (js) {
                    case "1":

//                        try {
//                            th.sleep(10000000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        } Log.e("123", "456");
                        setContentView(R.layout.pedestrain);
                        iv = findViewById(R.id.pedestrain);
                        iv.setImageResource(R.drawable.gif03);

                        break;
                    case "2":
//                        th.interrupt();
                        setContentView(R.layout.carfault);
                        iv = findViewById(R.id.carfault);
                        iv.setImageResource(R.drawable.gif01);
                        break;
                    case "3":
//                        th.interrupt();
                        setContentView(R.layout.temporary);
                        iv = findViewById(R.id.temporary);
                        iv.setImageResource(R.drawable.gif01);
                        break;
//                    case "4":
//                        th.notify();
                }
            }
        }
    };
}

//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            if (msg.what == 1) {
//                int count = (int) msg.obj;
//              switch (count) {
//                  case 0:
//                      setContentView(R.layout.zero_activity);
//                      iv_flower = (ImageView) findViewById(R.id.iv_zero);
//                      animationDrawable = (AnimationDrawable) iv_flower.getBackground();
//                      animationDrawable.start();
//                      break;
//
//                  case 1:
//                    animationDrawable.stop();
//                    setContentView(R.layout.gif_activity);
//                    iv = findViewById(R.id.gifImage);
//                    iv.setImageResource(R.drawable.gif01);
//                    break;
//
//                  case 2:
//                      Log.e("ooo","999");
//                      setContentView(R.layout.frist_activity);
//                      iv_flower = (ImageView) findViewById(R.id.iv_frist);
//                      animationDrawable = (AnimationDrawable) iv_flower.getBackground();
//                      animationDrawable.start();
//
//                  case 3:
//                      setContentView(R.layout.frist2_activity);
//                      iv_flower = (ImageView) findViewById(R.id.iv_frist);
//                      animationDrawable = (AnimationDrawable) iv_flower.getBackground();
//                      animationDrawable.start();
//                      break;
//
//                  case 4:
//                      animationDrawable.stop();
//                      setContentView(R.layout.gif_activity);
//                      iv = findViewById(R.id.gifImage);
//                      iv.setImageResource(R.drawable.gif02);
//                      break;
//
//                  case 5:
//                      setContentView(R.layout.second_activity);
//                      iv_flower = (ImageView) findViewById(R.id.iv_second);
//                      animationDrawable = (AnimationDrawable) iv_flower.getBackground();
//                      animationDrawable.start();
//                      break;
//
//                  case 6:
//                      setContentView(R.layout.second2_activity);
//                      iv_flower = (ImageView) findViewById(R.id.iv_second);
//                      animationDrawable = (AnimationDrawable) iv_flower.getBackground();
//                      animationDrawable.start();
//                      break;
//
//                  case 7:
//                      animationDrawable.stop();
//                      setContentView(R.layout.gif_activity);
//                      iv = findViewById(R.id.gifImage);
//                      iv.setImageResource(R.drawable.gif03);
//                      break;
//
//                  case 8:
//                      setContentView(R.layout.third_activity);
//                      iv_flower = (ImageView) findViewById(R.id.iv_third);
//                      animationDrawable = (AnimationDrawable) iv_flower.getBackground();
//                      animationDrawable.start();
//                      break;
//              }
//
//            }
//        }
//    };

