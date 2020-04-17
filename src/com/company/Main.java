package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // 1 вариант создать класс который будет наследоваться от Thread
        // 2 вариант имплементировать интерфейс Runnable

        MyThread t1 = new MyThread("+");
        t1.start();

        MyThread t2 = new MyThread("-");
        t2.start();

        Thread.sleep(2000);
        t1.flag = false;

        t1.join(); // t2 ждет завершение t1
        test("1-ый СТОП");

    }

    private static Object key = new Object();

    public static void test(String s) {
        try {
            synchronized(key) {
                System.out.print("[");
                Thread.sleep(100);
                System.out.print(s);
                Thread.sleep(100);
                System.out.print("]");
               // key.notify();
               // key.wait(); // выставляет поток в режим wait, до вызовы notify()
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
