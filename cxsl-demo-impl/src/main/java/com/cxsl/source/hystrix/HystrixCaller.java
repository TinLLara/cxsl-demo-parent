package com.cxsl.source.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @ClassName: HystrixCaller
* @Description: (hystrix caller)
* @author: tin
* @date: 2019-1-8 9:38
*/
public class HystrixCaller {
    private static Logger logger = LoggerFactory.getLogger(HystrixCaller.class);
    public static void main(String[] args) {
        logger.info("---info level---");
        ReadSourceCommand command = new ReadSourceCommand("demo0001");
        logger.debug("---debug level---");
        String result = command.execute();
        logger.error("---error level---");
        System.out.println(Thread.currentThread().getName() + "-->" + result);
    }
}