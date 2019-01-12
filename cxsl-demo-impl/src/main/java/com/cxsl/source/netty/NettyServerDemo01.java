package com.cxsl.source.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cxsl.source.netty.Handler.ServerHandler01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
* @ClassName: NettyServerDemo01
* @Description: (Netty源码阅读01)
* @author: lei3.shi@midea.com 
* @date: 2018-12-12 15:54
*/
public class NettyServerDemo01 {

    private static Logger logger = LoggerFactory.getLogger(NettyServerDemo01.class);
    /** 服务端口 */
    private int serverPort;

    public NettyServerDemo01(int serverPort) {
        this.serverPort = serverPort;
    }

    public void run() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
            .channel(NioServerSocketChannel.class)
            .option(ChannelOption.SO_BACKLOG, 2048)
            .childOption(ChannelOption.SO_KEEPALIVE, true)
            .childHandler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ServerHandler01());
                }
            });
        try {
            ChannelFuture channelFuture = serverBootstrap.bind(serverPort).sync();
            logger.info("Netty server is starting on port {}", serverPort);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 9000;
        new NettyServerDemo01(port).run();
    }
}