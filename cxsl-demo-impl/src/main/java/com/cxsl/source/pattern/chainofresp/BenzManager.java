package com.cxsl.source.pattern.chainofresp;

/**
 * 具体处理者 -- 奔驰项目经理
 */
public class BenzManager extends BenzHandler {
    @Override
    public void dealAfterSales(String customer, double price) {
        if (price < BENZ_PRICE) {
            if (!whoAmI.equals(customer)) {
                System.out.println("manager deal after sales:[" + customer + "],price is [" + price + "]");
            } else {
                System.out.println("manager deal: the buyer is not a postgraduate,manager can not handler it");
            }
        } else {
            handler.dealAfterSales(customer, price);
        }
    }
}
