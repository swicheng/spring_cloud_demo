package cn.itcast.juc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue<Runnable> t = new LinkedBlockingQueue<>(300);
        ThreadPoolExecutor  threadPoolExecutor= new ThreadPoolExecutor(100,400,10L, TimeUnit.MILLISECONDS,t,new ThreadPoolExecutor.CallerRunsPolicy());
  try {

        int i = 0;
        for ( i=0 ; i<10000 ; i++){
            int k = i;
            threadPoolExecutor.execute(()->{
                System.out.println(k);
            });
        }
      }finally {
         threadPoolExecutor.shutdown();
      }
    }

}
