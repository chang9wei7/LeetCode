package com.note4j.concurrent;

/**
 * Created by changwei on 2015/5/20.
 * V1.0.1 @note4j.com
 * Copyright (c) 2014-2015 All rights reserved.
 * <p/>
 * 线程池会保证在其中的线程与线程池的容量一致，当其中的某一个线程执行完成之后，另外的线程便能够进入线程池执行；若线程池满，则其他线程进入阻塞状态等等。
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor extends Thread {

    private int index;

    public MyExecutor(int i) {
        this.index = i;
    }

    static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date()) + ": ";
    }

    public void run() {
        try {
            System.out.println(now() + "[" + this.index + "] start....");
            Thread.sleep((int) (Math.random() * 10000));
            System.out.println(now() + "[" + this.index + "] end.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            service.execute(new MyExecutor(i));
            //service.submit(new MyExecutor(i));
        }
        System.out.println(now() + "submit finish");
        service.shutdown();
    }
}
