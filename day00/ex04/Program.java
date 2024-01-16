import java.util.Scanner;

public class Program {

   public static void sort(char[] letters, int[] append, int last_letter_pos) {
      for (int i = 0; i + 1 < last_letter_pos - 1; ++i) {
         for (int j = 0; j + 1 < last_letter_pos - i; ++j) {
            if (append[j + 1] < append[j]) {
               int temp = append[j];
               append[j] = append[j+1];
               append[j+1] = temp;

               char tempC = letters[j];
               letters[j] = letters[j+1];
               letters[j+1] = tempC;
            }
         }
      }
   }

   public static void lexicographicOrder(char[] letters, int[] append, int last_letter_pos) {
      for (int i = 0; i < last_letter_pos - 1; ++i) {
         for (int j = 0; j + 1 < last_letter_pos - i; ++j) {
            if (append[j] == append[j + 1]) {
               if (letters[j] < letters[j + 1]) {
                  char temp = letters[j];
                  letters[j] = letters[j + 1];
                  letters[j + 1] = temp;
               }
            }
         }
      }
   }

   public static void printResult(char[] letters, int[] append, int last_letter_pos) {
      int it = last_letter_pos - 1;
      for (int i = 0; i < 10; i++) {
         for (int j = 0; j < i; j++) {
            if (j == last_letter_pos) break;
            System.out.printf("#  ");
         }
         if (it >= 0) {
            System.out.printf("%d  ", append[it]);
            it--;
         }
         System.out.printf("\n");
      }
      if (last_letter_pos < 10) {
         for(int i = last_letter_pos - 1; i >= 0; --i) {
            if (i == 0) {
               System.out.printf("%c", letters[i]);
            } else {
               System.out.printf("%c  ", letters[i]);
            }
         }
      } else {
         for(int i = last_letter_pos - 1; i >= last_letter_pos - 10; --i) {
            if (i == last_letter_pos - 10) {
               System.out.printf("%c", letters[i]);
            } else {
               System.out.printf("%c  ", letters[i]);
            }
         }
      }
   }

   public static int writeUniqueSymbols(char[] input_str, char[] letters, int[] append) {
      int last_letter_pos = 1;
      letters[0] = input_str[0];
      append[0] = 1;
      for(int i = 1; i < input_str.length; ++i) {
         boolean flag = true;
         if (input_str[i] != letters[0]) {
            for (int j = 1; j < letters.length; ++j) {
               if (input_str[i] == letters[j]) {
                  ++append[j];
                  flag = false;
                  break;
               }
            }
            if (flag) {
               letters[last_letter_pos] = input_str[i];
               append[last_letter_pos] = 1;
               ++last_letter_pos;
            }
         } else {
            ++append[0];
         }
      }
      return last_letter_pos;
   }


   public static void main(String []args) {
    Scanner input = new Scanner (System.in);
    String str = input.nextLine();
    char[] input_str = str.toCharArray();
    char[] letters = new char[input_str.length];
    int[] append = new int[input_str.length];
    if (str.isEmpty()) System.exit(-1);
    int last_letter_pos = writeUniqueSymbols(input_str, letters, append);
    sort(letters, append, last_letter_pos);
    lexicographicOrder(letters, append, last_letter_pos);
    printResult(letters, append, last_letter_pos);
   }
}
