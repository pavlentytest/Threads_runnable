package com.company;

public class MyThread extends Thread{

    private String message;
    public boolean flag = true;

    public MyThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while(flag) {
            Main.test(this.message);
        }
    }
}

