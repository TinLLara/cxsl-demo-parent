package com.cxsl.source.pattern.chainofresp;

/**
 * 责任链模式
 * 1、定义抽象处理者 -- BenzHandler.java
 * 2、分别定义具体处理者 -- BenzManager.java\BenzBoss.java
 * 3、责任链关联
 */
public class DemoMain {
    public static void main(String[] args) {
        BenzHandler manager = new BenzManager();
        BenzHandler boss = new BenzBoss();
        boss.setHandler(manager);

        boss.dealAfterSales("undergraduate", 600000);
        System.out.println("-----");
        boss.dealAfterSales("postgraduate", 6600000);
    }
}
