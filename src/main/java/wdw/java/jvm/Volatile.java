package wdw.java.jvm;

import java.util.Scanner;

public class Volatile implements Runnable{

//    private static volatile boolean flag = true ;
    private static boolean flag = true ;

    @Override
    public void run() {
        while (flag){
        }
        System.out.println(Thread.currentThread().getName() +"执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile aVolatile = new Volatile();
        new Thread(aVolatile,"thread A").start();


        System.out.println("main 线程正在运行") ;

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String value = sc.next();
            if(value.equals("1")){

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        aVolatile.stopThread();
                    }
                }).start();
//                aVolatile.stopThread();

                break ;
            }
        }

        System.out.println("主线程退出了！");

    }

    private void stopThread(){
        flag = false ;
    }

}