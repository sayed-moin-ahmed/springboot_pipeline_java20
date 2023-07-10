package com.pipeline.sample.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class VirtualThreads {

    public void sampleVirtualThreads() throws InterruptedException {
        Runnable runnable = ()->System.out.println("Hello from a different thread");
        ExecutorService executorService = getExecutorService();
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.submit(runnable);
    }

    public ExecutorService getVirtualThreadExecutorService(){
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        return executorService;
    }

    public ExecutorService getExecutorService(){
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        return executorService;
    }

    class CustomThreadFactory implements ThreadFactory{

        @Override
        public Thread newThread(Runnable r) {
            return  new Thread(r);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        VirtualThreads virtualThreads =  new VirtualThreads();
        virtualThreads.sampleVirtualThreads();
    }

}
