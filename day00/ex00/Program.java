public class Program {

   public static void main(String []args) {
    int number = 123456;
    int result = 0;
    while (number != 0) {
        result += number % 10;
        number = number / 10;
    }
    System.out.printf("%d", result);
   }
}