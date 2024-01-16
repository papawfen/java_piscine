package ex02;
import java.util.Random;
class Thread1 extends Thread {

    public Thread1() {}

    @Override
    public void run() {
            try{
                Thread.sleep(500);
            } catch(InterruptedException e) {}
    }

    public static int sumNum(int[] array, int count, int steps) {
        int result = 0;
        for (int i = count; i < count + steps; ++i) {
            result += array[i];   
        }
        return result;
    }
}


public class Program {
    static Thread1 first;
    public static void main(String[] args) {
        int arraySize = Integer.parseInt(args[0].split("=")[1]);
        int threadsCount = Integer.parseInt(args[1].split("=")[1]);
        Random num = new Random();
        int[] array = new int[arraySize];
        int temp = 0;
        for (int i = 0; i < array.length; ++i) {
            array[i] = num.nextInt(1001);
            temp += array[i];
        }
        System.out.print("Sum: " + temp + "\n");
        first = new Thread1();
        int size = 0;
        int result = 0;
        int steps = arraySize / threadsCount;
        for (int i = 0; i < threadsCount; ++i) {
            Thread firstThread = new Thread(first);
            firstThread.start();
            result += Thread1.sumNum(array, size, steps);
            size += steps;
            if (size > array.length) {
                size -= array.length;
            }
        }
        Thread firstThread = new Thread(first);
        firstThread.start();
        size = arraySize - arraySize % threadsCount;
        steps = arraySize % threadsCount;
        result += Thread1.sumNum(array, size, steps);
        System.out.print("Sum by threads: " + result + "\n");
    }
}