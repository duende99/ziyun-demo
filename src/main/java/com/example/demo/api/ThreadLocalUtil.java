package com.example.demo.api;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalUtil {

    private static final AtomicInteger nextid = new AtomicInteger(0);
    private static final ThreadLocal<Integer> thread = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextid.getAndIncrement();
        }
    };
    private static final ThreadLocal<Map<String,Object>> thread2 = new ThreadLocal<Map<String,Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };
    public static int get() {
        return thread.get();
    }
    public static void remove() {
        thread.remove();
    }
}

class test {
    public static void inc() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + " " + i + "  " + ThreadLocalUtil.get());
            }
        } catch (Exception e) {

        } finally {
            ThreadLocalUtil.remove();
        }
    }
    public static void main(String[] args) {
        inc();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                inc();
            }
        }).start();
    }
}
