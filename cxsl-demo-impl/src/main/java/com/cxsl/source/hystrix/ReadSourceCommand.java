package com.cxsl.source.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
* @ClassName: ReadSourceCommand
* @Description: (hystrix source reading demo)
* @author: tin
* @date: 2019-1-8 9:40
*/
public class ReadSourceCommand extends HystrixCommand<String>{

    private Logger logger = LoggerFactory.getLogger(ReadSourceCommand.class);

    private static final int COMMAND_POOL_CORE_SIZE = 5;

    private String flag = null;


    protected ReadSourceCommand(String flag) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ReadSourceGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("ReadSourceCmd"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ReadSourcePool"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(5))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(COMMAND_POOL_CORE_SIZE)));
        this.flag = flag;
    }


    @Override
    protected String run() throws Exception {
        logger.info("{}执行run()方法中业务操作...", flag);
        Thread.sleep(6000);
        return null;
    }

    @Override
    protected String getFallback() {
        logger.error("{}执行getFallback返回托底操作...", flag);
        return null;
    }
}