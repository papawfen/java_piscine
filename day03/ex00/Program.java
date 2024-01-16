package ex00;

class Thread1 extends Thread {

    public Thread1(int newCount) { count = newCount; }

    @Override
    public void run() {
        for (int i = 0; i < count; ++i) {
            System.out.println("Egg");
            try{
                Thread.sleep(500);
            } catch(InterruptedException e) {}
        }
        return;
    }

    private int count;
}

class Thread2 extends Thread {

    public Thread2(int newCount) { count = newCount; }

    @Override
    public void run() {
        for (int i = 0; i < count; ++i) {
            System.out.println("Hen");
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){}
        }
        return;
    }

    private int count;
}

public class Program {
    static Thread1 first;
    static Thread2 second;
    public static void main(String[] args) {
        String tmp = args[0].split("=")[1];
        int count = Integer.valueOf(tmp);

        first = new Thread1(count);
        Thread firstThread = new Thread(first);
        second = new Thread2(count);
        Thread secondThread = new Thread(second);
        firstThread.start();
        secondThread.start();
        while(firstThread.isAlive() && secondThread.isAlive()) {}
        for (int i = 0; i < count; ++i) {
            System.out.println("Human");
        }
    }
}
