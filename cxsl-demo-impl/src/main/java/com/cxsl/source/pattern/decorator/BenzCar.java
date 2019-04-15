package com.cxsl.source.pattern.decorator;

/**
 * 定义被装饰者
 * 漏油牌奔驰汽车，售价66万
 */
public class BenzCar extends Car {

    @Override
    public String getCarDesc() {
        return "this is BenzCar, an oil-related car.";
    }

    @Override
    public Double getPrice() {
        return Double.valueOf(660000);
    }
}