package com.asiainfo.permission.controller;


import java.util.UUID;

/**
 * @ClassName TestUUID
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/8 15:47
 **/
public class TestUUID {

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
