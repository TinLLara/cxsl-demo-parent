package com.cxsl.source.pattern.decorator;

/**
 * 定义装饰者抽象类
 */
public abstract class Decorator extends Car {
    @Override
    public abstract String getCarDesc();
}