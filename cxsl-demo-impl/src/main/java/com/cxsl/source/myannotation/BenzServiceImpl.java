package com.cxsl.source.myannotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(
        value = "benzService"
)
public class BenzServiceImpl {

    @BenzAfterSale(behavior = "benz will change engine")
    public void benzDoSomething() {
        System.out.println("it's benz doing something...");
    }
}
