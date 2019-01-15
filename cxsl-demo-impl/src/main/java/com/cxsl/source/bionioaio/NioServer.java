package com.cxsl.source.bionioaio;
/**
* @Description:    nio服务端
* @Author:         tin
* @CreateDate:     2019/1/15 9:57 PM
* @Version:        1.0
*/
public class NioServer {
    private static int DEFAULT_PORT = 12345;
    private static NioServerHandle serverHandle;
    public static void start(){
        start(DEFAULT_PORT);
    }
    public static synchronized void start(int port){
        if(serverHandle!=null)
            serverHandle.stop();
        serverHandle = new NioServerHandle(port);
        new Thread(serverHandle,"Server").start();
    }
    public static void main(String[] args){
        start();
    }
}
