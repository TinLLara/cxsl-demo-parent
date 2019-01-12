package com.cxsl.source.netty.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
* @ClassName: ServerHandler01
* @Description: (Netty server-side handler.)
* @author: tin
* @date: 2018-12-13 11:41
*/
public class ServerHandler01 extends SimpleChannelInboundHandler<String> {

    private Logger logger = (Logger) LoggerFactory.getLogger(ServerHandler01.class);

    /**
     * Is called for each message of type {@link I}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param msg the message to handle
     * @throws Exception is thrown if an error occurred
     */
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        logger.info("server-info:the client's request msg is {}", msg);
        System.out.println("ddddddd" + msg);

    }
}