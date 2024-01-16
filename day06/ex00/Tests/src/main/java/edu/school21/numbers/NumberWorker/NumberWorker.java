package edu.school21.numbers.NumberWorker;

public class NumberWorker {
    public NumberWorker() {}

    public boolean isPrime(int number) throws IllegalArgumentException {
        if (number <= 1)  { throw new IllegalArgumentException("IllegalNumberException"); }
        if (number % 2 == 0) { return false; }
        boolean prime = true;
        int i;
        for (i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }
    return prime;
    }

    public int digitSum(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }
}
