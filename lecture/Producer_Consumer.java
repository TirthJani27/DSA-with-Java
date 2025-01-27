package com.dsa.javalearning.lecture;

class Q {
    int num;
    boolean flag = false;
    synchronized void put(int num){
        while(flag){
            try{
                wait();
            }catch (Exception e){}
        }
        System.out.println("Put :" + num);
        this.num = num;
        flag=true;
        notify();
    }
    synchronized void get(){
        while (!flag){
            try {
                wait();
            }catch (Exception e ){}
        }
        System.out.println("Get :" + num);
        flag = !flag;
        notify();
    }

}
class Producer implements Runnable{
    Q q;
    Producer(Q q){
        this.q=q;
        Thread t =new Thread(this,"Producer");
        t.start();
    }
    @Override
    public void run() {
        int i=0;
        while(true){
            q.put(i++);
            try{
                Thread.sleep(5000);
            }catch (Exception e ){}
        }
    }
}
class Consumer implements Runnable{
    Q q;
    Consumer(Q q){
        this.q=q;
        Thread t =new Thread(this,"Consumer");
        t.start();
    }
    @Override
    public void run() {
        while(true){
            q.get();
            try{
                Thread.sleep(5000);
            }catch (Exception e ){}
        }
    }
}
public class Producer_Consumer {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
