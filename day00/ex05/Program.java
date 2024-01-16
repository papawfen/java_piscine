import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String []args) {
        Scanner input = new Scanner (System.in);
        Scanner int_input = new Scanner (System.in);
        int[] time = new int[42];
        int[] class_time = new int[42];
        char[][] names = new char[10][10];
        char[][] date = new char[10][2];
        char[][] classes = new char[10][14];
        int dot_count = 0;
        int name_count = 0, date_count = 0, class_count = 0;
        while (dot_count != 3) {
            String str = input.nextLine();
            if (str.equals(".")) {
                ++dot_count;
                continue;
            }
            if (dot_count == 0) {
                char[] temp = str.toCharArray();
                for (int i = 0; i < temp.length; ++i) {
                    names[name_count][i] = temp[i];
                }
                ++name_count;
            }
            if (dot_count == 1) {
                str = str.replaceAll(" ", "");
                char[] temp = str.toCharArray();
                for (int i = 0; i < temp.length - 1; ++i) {
                    time[i] = Character.getNumericValue(temp[0]);
                    date[date_count][i] = temp[i + 1];
                }
                ++date_count;
            }
            if (dot_count == 2) {
                str = str.replaceAll("NOT_HERE", "0");
                str = str.replaceAll("HERE", "1");
                str = str.replaceAll(" ", "|");
                char[] temp = str.toCharArray();
                for (int i = 0; i < temp.length; ++i) {
                    classes[class_count][i] = temp[i];
                }
                ++class_count;
            }
        }
        System.out.printf("\t");
        for (int j = 0; j < 29; j += 7) {
            for (int i = 0; i < date_count; ++i) {
                if (date[i][0] == 'M' && date[i][1] == 'O')
                    System.out.print(time[i] + ":00" + " " + date[i][0] + date[i][1] + "  " + (7 + j) + "|");
                if (date[i][0] == 'T' && date[i][1] == 'U')
                    System.out.print(time[i] + ":00" + " " + date[i][0] + date[i][1] + "  " + (1 + j) + "|");
                if (date[i][0] == 'W' && date[i][1] == 'E')
                    System.out.print(time[i] + ":00" + " " + date[i][0] + date[i][1] + "  " + (2 + j) + "|");
                if (date[i][0] == 'T' && date[i][1] == 'H')
                    System.out.print(time[i] + ":00" + " " + date[i][0] + date[i][1] + "  " + (3 + j) + "|");
                if (date[i][0] == 'F' && date[i][1] == 'R')
                    System.out.print(time[i] + ":00" + " " + date[i][0] + date[i][1] + "  " + (4 + j) + "|");
                if (date[i][0] == 'S' && date[i][1] == 'A')
                    System.out.print(time[i] + ":00" + " " + date[i][0] + date[i][1] + "  " + (5 + j) + "|");
                if (date[i][0] == 'S' && date[i][1] == 'U')
                    System.out.print(time[i] + ":00" + " " + date[i][0] + date[i][1] + "  " + (6 + j) + "|");                       
            }
        }
        System.out.printf("\n");
        for (int i = 0; i < name_count; ++i) {
            char[] temp = new char[10];
            for (int j = 0; j < 10; ++j) {
                temp[j] = names[i][j];
                System.out.printf("%c", temp[j]);
            }
            System.out.print("              |");
        } 





        // for (int i = 0; i < class_count; ++i) {
        //     for (int j = 0; j < 14; ++j) {
        //         System.out.printf("%c", classes[i][j]);
        //     }
        //     System.out.printf("\n");
        // }
    }
 }