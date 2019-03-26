package com.cxsl.source.proxy;
/**
* @Description:    业务接口
* @Author:         tin
* @CreateDate:     2019/3/26 8:49 PM
* @Version:        1.0
*/
public class GreetingServiceImpl implements GreetingInterface{
    @Override
    public void sayHi(String content) {
        System.out.println("sayHi:" + content);
    }
}
