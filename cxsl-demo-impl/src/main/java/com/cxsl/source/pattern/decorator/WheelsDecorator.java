package com.cxsl.source.pattern.decorator;

/**
 * 轮子装饰者
 * 漏油牌奔驰，不但发动机要备，轮子也是有备无患。
 */
public class WheelsDecorator extends Decorator{
    Car car;

    public WheelsDecorator(Car car) {
        this.car = car;
    }

    @Override
    public String getCarDesc() {
        return car.getCarDesc() + " added four wheels.";
    }

    @Override
    public Double getPrice() {
        return car.getPrice() + 6000;
    }
}