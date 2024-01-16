package edu.school21.numbers;
import edu.school21.numbers.NumberWorker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.*;


public class NumberWorkerTest {

    @ParameterizedTest
    @ValueSource(ints = {13, 7, 17})
    public void isPrimeForPrimes(int number) throws Exception {
        NumberWorker num = new NumberWorker();
        Assert.assertTrue(num.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 40, 100})
    public void isPrimeForNotPrimes(int number) throws Exception {
        NumberWorker num = new NumberWorker();
        Assert.assertFalse(num.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -100})
    public void isPrimeForIncorrectNumbers(int number) throws IllegalArgumentException {
        NumberWorker num = new NumberWorker();
        Assertions.assertThrows(IllegalArgumentException.class, () -> num.isPrime(number));

    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/data.csv"})
    public void digitsSum(int my, int expect) {
        NumberWorker num = new NumberWorker();
        Assert.assertEquals(num.digitSum(my), expect);
    }
}
