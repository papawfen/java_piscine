import java.util.Scanner;

public class Program {

   public static void main(String []args) {
    Scanner input = new Scanner (System.in);
    int number = input.nextInt();
    if (number <= 1) {
        System.err.printf("Illegal Argument");
        System.exit(-1);
    }
    if (number % 2 == 0) {
        System.out.printf("false 1");
        System.exit(1);
    }
    boolean prime = true;
    int i;
    for (i = 3; i <= Math.sqrt(number); i += 2) {
        if (number % i == 0) {
            System.out.printf("false %d", i - 1);
            prime = false;
            break;
        }
    }
    if (prime)
        System.out.printf("true %.0f", Math.sqrt(number) - 1);
   }
}