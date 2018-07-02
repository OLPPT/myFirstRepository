package com.example.demo.blockingqueue;

import java.util.concurrent.*;

/**
 * Created by OL-PC on 2018/05/30.
 */
public class BlockQueueTest {
    private static int capacity = 5;
    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(capacity);

    public static void main(String[] args) {
//        Thread product = new Thread(() -> {
//
//        });
//
//        Thread customer = new Thread(()->{
//
//        });
        ExecutorService executor = Executors.newCachedThreadPool();
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) executor;
        System.out.println(tpe.getLargestPoolSize());
        Task task = new Task();
        FutureTask futureTask = new FutureTask(task);
        executor.submit(futureTask);
//        executor.shutdown();

//        Task task = new Task();
//        FutureTask futureTask = new FutureTask(task);
//        Thread t = new Thread(futureTask);
//        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
        System.out.println(tpe.getLargestPoolSize());
        System.out.println("-->" + executor.isShutdown());
        executor.shutdown();
        System.out.println("-->" + executor.isShutdown());
//        Thread deamon = new Thread(new DaemonRunner(),"DaemonRunner");
//        //设置为守护线程
//        deamon.setDaemon(true);
//        deamon.start();//启动线程
    }

    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("子进程计算。。。");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0;i < 100;i++){
                sum += i;
            }
            return sum;
        }
    }
    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                System.out.println("这里的代码在java虚拟机退出时并不一定会执行哦！");
            }
        }
    }
}
