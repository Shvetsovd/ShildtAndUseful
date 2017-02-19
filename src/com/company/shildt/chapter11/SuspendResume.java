package company.shildt.chapter11;

import company.shildt.chapter7.StringDemo;

/**
 * Created by dmitry on 20.02.17.
 */
class NewThread1 implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    public NewThread1(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 15; i > 0; i--) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " завершен");
    }

    synchronized void mySuspend(){
        suspendFlag = true;
    }

    synchronized void myResume(){
        suspendFlag = false;
        notify();
    }
}

public class SuspendResume {
    public static void main(String[] args) {
        NewThread1 ob1 = new NewThread1("Один");
        NewThread1 ob2 = new NewThread1("Два");

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Приостановка потока Один");
            ob1.myResume();
            System.out.println("Возобновление потока Один");
            ob2.mySuspend();
            System.out.println("Приостановка потока Два");
            ob2.myResume();
            System.out.println("Возобновление потока Два");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ожидание завершения потоков");
        try {
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Главный поток завершен");
    }
}
