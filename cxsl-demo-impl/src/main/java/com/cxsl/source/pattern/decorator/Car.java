package com.cxsl.source.pattern.decorator;

/**
 * 装饰者模式
 * 公共父类，可以是抽象类或接口，抽象类可提取公共行为或属性
 */
public abstract class Car {

    private String carDesc = "Car";

    public String getCarDesc() {
        return carDesc;
    }

    public abstract Double getPrice();
}