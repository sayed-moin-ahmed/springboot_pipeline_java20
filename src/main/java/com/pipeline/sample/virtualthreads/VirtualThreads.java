package com.pipeline.sample.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class VirtualThreads {

    public void sampleVirtualThreads() throws InterruptedException {
        Runnable runnable = ()->System.out.println("Hello from a different thread");
        Thread.Builder  builder =  Thread.ofVirtual().name("worker-",0);
        Thread t1 = builder.start(runnable);
        t1.join();
        Thread t2 = builder.start(runnable);
        t2.join();

        getExecutorService();
    }

  public ExecutorService getExecutorService(){
                ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        return executorService;
  }



    public static void main(String[] args) throws InterruptedException {
        VirtualThreads virtualThreads =  new VirtualThreads();
        virtualThreads.sampleVirtualThreads();
    }

}
