package com.cxsl.source.pattern.chainofresp;

/**
 * 具体处理者 -- 奔驰老板处理
 */
public class BenzBoss extends BenzHandler {
    @Override
    public void dealAfterSales(String customer, double price) {
        if (price >= BENZ_PRICE) {
            if (whoAmI.equals(customer)) {
                System.out.println("boss deal after sales:[" + customer + "],price is [" + price + "]");
            } else {
                System.out.println("boss deal: the buyer is not a postgraduate,manager can not handler it");
            }
        } else {
            this.handler.dealAfterSales(customer, price);
        }
    }
}
