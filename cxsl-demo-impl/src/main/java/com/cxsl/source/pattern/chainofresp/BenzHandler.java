package com.cxsl.source.pattern.chainofresp;

/**
 * 抽象处理者 -- 一般为接口或抽象类，定义处理对象与行为
 */
public abstract class BenzHandler {

    protected BenzHandler handler = null;

    protected static final double BENZ_PRICE = 6600000;

    protected static final String whoAmI = "postgraduate";

    public BenzHandler getHandler() {
        return handler;
    }

    public void setHandler(BenzHandler handler) {
        this.handler = handler;
    }
    public abstract void dealAfterSales(String customer, double price);
}
