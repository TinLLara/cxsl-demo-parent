package com.cxsl.source.pattern.decorator;

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