package com.cxsl.source.bionioaio;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
/**
* @Description:    作为handler接收客户端连接
* @Author:         tin
* @CreateDate:     2019/1/15 10:46 PM
* @Version:        1.0
*/
public class AioServerAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncServerHandler> {
    @Override
    public void completed(AsynchronousSocketChannel channel,AsyncServerHandler serverHandler) {
        //继续接受其他客户端的请求
        AioServer.clientCount++;
        System.out.println("连接的客户端数：" + AioServer.clientCount);
        serverHandler.channel.accept(serverHandler, this);
        //创建新的Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //异步读  第三个参数为接收消息回调的业务Handler
        channel.read(buffer, buffer, new AioServerReadHandler(channel));
    }
    @Override
    public void failed(Throwable exc, AsyncServerHandler serverHandler) {
        exc.printStackTrace();
        serverHandler.latch.countDown();
    }
}
