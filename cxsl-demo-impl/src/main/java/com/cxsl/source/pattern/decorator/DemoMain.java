package com.cxsl.source.pattern.decorator;

/**
 * Demo主入口类
 * 装饰者模式
 * 1、装饰者与被装饰者父类 -- 接口或抽象类，定义基本行为 Car.java;
 * 2、被装饰者类定义 实现1中接口或继承抽象类 BenzCar.java;
 * 3、抽象装饰者 同样实现1中接口或继承抽象类 Decorator.java;
 * 4、具体装饰者，继承3中抽象装饰者 EngineDecorator.java\WheelsDecorator.java;
 * @author tin
 */
public class DemoMain {
    public static void main(String[] args) {
        /**
         * 漏油牌奔驰，66万那种
         */
        Car benzCar = new BenzCar();
        System.out.println(benzCar.getCarDesc() + " total price:" + benzCar.getPrice());

        /**
         * 漏油牌奔驰，加个发动机
         */
        Car engineAddedCar = new EngineDecorator(benzCar);
        System.out.println(engineAddedCar.getCarDesc() + " total price:" + engineAddedCar.getPrice());

        /**
         * 漏油牌奔驰，加四个车轮胎
         */
        Car wheelsAddedCar = new WheelsDecorator(benzCar);
        System.out.println(wheelsAddedCar.getCarDesc() + " total price:" + wheelsAddedCar.getPrice());
    }
}