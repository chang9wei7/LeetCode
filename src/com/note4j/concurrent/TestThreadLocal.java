package com.note4j.concurrent;

/**
 * Created by changwei on 2015/4/21.
 * V1.0.1 @note4j.com
 * Copyright (c) 2014-2015 All rights reserved.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestThreadLocal {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialVal() {
            return 0;
        }
    };

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    private static class TestClient extends Thread{
        TestClient t ;
    }

    public static void main(String[] args) throws Exception {
    StringBuffer str = new StringBuffer();
    }
}
