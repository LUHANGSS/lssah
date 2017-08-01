package com.lh.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
/**java多线程，线程池
 * Created by 路航 on 2017/7/31 0031.
 */
public class duoxiancheng {
    public static void main(String[] args) {
    // 创建一个固定线程数为三的线程池
    ExecutorService pool = Executors.newFixedThreadPool(3);
    // 创建三个线程
        Threadpool t = new Threadpool();
        // 通过execute(Runnable command)方法传入对象并在线程池运行
    pool.execute(t);
    pool.execute(t);
    pool.execute(t);
    // 关闭创建的线程池
        pool.shutdown();
    }
}
class Threadpool implements Runnable{
    int num = 200;
    boolean b = true;
    public void run() {
        while(b) {
            sell();
        }
    }
    public synchronized void sell(){
        if(num>0){
            try{
                Thread.sleep(10);//休眠10毫秒看是否同步
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖出tickets"+ num--);//售票为例
        }
        else {
            b=false;
        }

    }
}
