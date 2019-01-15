package com.cxsl.source.bionioaio;
/**
* @Description:    nio客户端
* @Author:         tin
* @CreateDate:     2019/1/15 10:02 PM
* @Version:        1.0
*/
public class NioClient {
    /**
     * 客户端地址
     */
    private static String DEFAULT_HOST = "127.0.0.1";
    /**
     * 客户端端口
     */
    private static int DEFAULT_PORT = 12345;
    /**
     * 请求开关
     */
    private static String SWITCH_CODE = "quit";
    /**
     * 客户端处理对象
     */
    private static NioClientHandle clientHandle;

    public static void start(){
        start(DEFAULT_HOST,DEFAULT_PORT);
    }

    public static synchronized void start(String ip,int port){
        if(clientHandle!=null) {
            clientHandle.stop();
        }
        clientHandle = new NioClientHandle(ip,port);
        new Thread(clientHandle,"Server").start();
    }

    /**
    * @Description: 向服务器发送消息
    * @author      tin
    * @return      boolean
    * @exception
    * @date        2019/1/15 10:06 PM
    */
    public static boolean sendMsg(String msg) throws Exception{
        if(SWITCH_CODE.equals(msg)) { return false;}
        clientHandle.sendMsg(msg);
        return true;
    }

    public static void main(String[] args){
        start();
    }
}
