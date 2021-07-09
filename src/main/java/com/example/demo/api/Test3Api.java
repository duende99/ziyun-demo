package com.example.demo.api;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class Test3Api {

    public static void main(String[] args) {

        ExecutorService ex = Executors.newFixedThreadPool(10);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ThreadLocal<SimpleDateFormat> sdfThread = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
        ThreadLocal<Integer> thread2 = ThreadLocal.withInitial(() -> 100);


//        list.forEach(o -> {
//            ex.execute(() -> {
//                try {
//                    Date date = sdf.parse("2021-01-01");
//                    System.out.println(date);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//        });

        for (int i = 0; i < 100 - 1; i++) {
//            try {
//                Thread.sleep(10);
//            } catch (Exception e) {
//
//            }
            ex.execute(() -> {
                try {
//                    Date date = sdf.parse("2021-01-01");
                    Date date = sdfThread.get().parse("2021-01-01");
//                    System.out.println(date);
                    Integer integer = thread2.get();
                    System.out.println(integer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }
    public static void run(int i) {
        System.out.println(Thread.currentThread().getName() + " " + i);
    }



}