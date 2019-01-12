package com.cxsl.source;

import com.cxsl.utils.CxslTest;

public class CxslTestDemo {

    public static void main(String[] args) {
        CxslTest cxslTest = new CxslTest();
        cxslTest.sayHello("tin");
        byte t1 = 1;
        Byte t2 = new Byte((byte) 1);
        System.out.println(t1==t2);
    }
}