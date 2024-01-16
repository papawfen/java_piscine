package ex01;

import java.nio.channels.SocketChannel;
import java.util.ServiceConfigurationError;

class Table {
    public void synch(String msg) {
        System.out.println(msg);
        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {}
    }
}

class Thread1 extends Thread {
    Table print;

    public Thread1(Table object) { 
        print = object;
    }

    @Override
    public void run() {
        synchronized(print) {
            print.synch("Egg");
        }
        return;
    }
}

class Thread2 extends Thread {
    Table print;

    public Thread2(Table object) { 
        print = object;
    }

    @Override
    public void run() {
        synchronized(print) {
            print.synch("Hen");
        }
        return;
    }
}

public class Program {
    static Thread1 first;
    static Thread2 second;
    public static void main(String[] args) {
        String tmp = args[0].split("=")[1];
        int count = Integer.valueOf(tmp);
        Table obj = new Table();


        for (int i =0; i < count; ++i) {
            Thread1 first = new Thread1(obj);
            Thread2 second = new Thread2(obj);
            first.start();
            second.start();
            try {
                first.join();
            } catch(InterruptedException e) {}
            try {
                second.join();
            } catch(InterruptedException e) {}
        }
    }
}
