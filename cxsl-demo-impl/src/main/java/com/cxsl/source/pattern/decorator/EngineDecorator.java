package com.cxsl.source.pattern.decorator;

/**
 * 发动机装饰者
 * 漏油牌奔驰，需要外加一个发动机，不然开一公里就不行了。
 */
public class EngineDecorator extends Decorator {
    Car car;

    public EngineDecorator(Car car) {
        this.car = car;
    }

    @Override
    public String getCarDesc() {
        return car.getCarDesc() + " added a engine.";
    }

    @Override
    public Double getPrice() {
        return car.getPrice() + 100000;
    }
}