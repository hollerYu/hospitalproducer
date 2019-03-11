package com.jk.untils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        System.out.println("second DynamicTask，" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
