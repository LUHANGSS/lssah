package com.lh.demo;

import java.io.*;
import java.net.*;

class Send implements Runnable {

    private Socket s;
    Send(Socket s){
        this.s = s;
    }
    public void run() {
        try {
            //建立客户端对象
            Socket s = new Socket(InetAddress.getLocalHost(), 10086);
            //键盘录入
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
            //打印输出键盘读取内容
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            String line = null;
            while ((line = bufr.readLine()) != null) {
                if ("88".equals(line))
                    break;
                out.println(line);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("客户端错误");//捕获处理异常
        }

    }
}


class Rece implements Runnable {

    private ServerSocket ss;
    Rece(ServerSocket ss){
        this.ss = ss;
    }

    public void run() {
        try {
            while (true) {
                Socket s = ss.accept();//接受客户端的连接请求，并返回一个新的套接字
                //读取网络流发来的信息
                BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
                //获取客户端ip信息
                String ip = s.getInetAddress().getHostAddress();
                //输出客户端发来的信息
                String line = null;
                while ((line = bufIn.readLine()) != null) {

                    System.out.println("来自" + ip + "： " + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("服务端错误");//捕获异常
        }
    }

}
public class Tcpclient{
    public static void main(String[] args) throws IOException {
        Socket s = new Socket();//建立客户端Socket服务
        ServerSocket ss = new ServerSocket(10086);//建立服务端Socket服务，并监听一个端口

        new Thread(new Send(s)).start();//客户端线程启动
        new Thread(new Rece(ss)).start();//服务端线程启动

    }
}