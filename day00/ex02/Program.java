import java.util.Scanner;

public class Program {

   public static void main(String []args) {
    Scanner input = new Scanner (System.in);
    int number = input.nextInt();
    int j = 0;
    while (number != 42) {
        if (number <= 1) {
            number = input.nextInt();
            continue;
        }
        int result = 0;
        boolean prime = true;
        while (number != 0) {
            result += number % 10;
            number = number / 10;
        }
        for (int i = 2; i < Math.sqrt(result); i++) {
            if (result % i == 0) {
                prime = false;
            }
        }
        if (prime) j++;
        number = input.nextInt();
    }
    System.out.printf("Count of coffee-request – %d", j);

   }
}