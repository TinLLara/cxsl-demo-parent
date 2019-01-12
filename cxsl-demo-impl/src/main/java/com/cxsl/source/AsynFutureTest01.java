package com.cxsl.source;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsynFutureTest01 {
    final static ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();
        Future<Map<String, String>> rpcFuture = null;
        Future<Integer> httpFuture = null;

        rpcFuture = EXECUTOR_SERVICE.submit(rpcService);
        httpFuture = EXECUTOR_SERVICE.submit(httpService);

        Map<String, String> rpcResultFuture = rpcFuture.get( 500, TimeUnit.MILLISECONDS);
        Integer httpResultFuture = httpFuture.get(500, TimeUnit.MILLISECONDS);
        System.out.println(httpResultFuture);
    }

    static class  RpcService implements Callable<Map<String, String>> {
        Map<String, String> getRpcResult() throws InterruptedException {
            System.out.println("here called rpc-service...");
            Thread.sleep(100);
            return null;
        }

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Map<String, String> call() throws Exception {
            return this.getRpcResult();
        }
    }

    static class HttpService implements Callable<Integer> {
        Integer getHttpResult() throws InterruptedException {
            System.out.println("here called http-service...");
            Thread.sleep(200);
            return null;
        }

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Integer call() throws Exception {
            return this.getHttpResult();
        }
    }
}