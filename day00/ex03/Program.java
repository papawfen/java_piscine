import java.util.Scanner;

public class Program {

   public static void main(String []args) {
    Scanner input = new Scanner (System.in);
    Scanner input_num = new Scanner (System.in);
    String week = input.nextLine();
    if ((!week.startsWith("week") || !week.endsWith(" 1")) && !week.equals("42")) {
        System.err.printf("Illegal Argument");
        System.exit(-1);
    }
    int min_test = 10;
    int week_num = 1;
    String[] result = new String[10];
    while (!week.equals("42")) {
        min_test = 10;
        if (!week.startsWith("week") || !week.endsWith(" " + String.valueOf(week_num))) {
            System.err.printf("Illegal Argument");
            System.exit(-1);
        }
        for (int i = 0; i < 5; ++i) {
            int tests = input_num.nextInt();
            if (tests < 1 || tests > 9) {
                System.err.printf("Illegal Argument");
                System.exit(-1);
            }
            if (min_test > tests) {
                min_test = tests;
            }
        }
        result[week_num - 1] = String.valueOf(min_test);
        week = input.nextLine();
        ++week_num;
        if (week_num > 18) {
            System.err.printf("Illegal Argument");
            System.exit(-1); 
        }
    }
    for (int j = 0; j < week_num - 1; j++) {
        System.out.printf("week %d", j + 1);
        for (int i = 1; i <= Integer.valueOf(result[j]); i++) {
            System.out.printf("=");
        }
        System.out.printf(">\n");
    }
   }
}