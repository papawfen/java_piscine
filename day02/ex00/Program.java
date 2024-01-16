package ex00;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.*;


public class Program {

    PreparedStatement preparedstatement;

    public static StringBuilder convertToProgram(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        int bytesCounter = 0;
        int value = 0;
        StringBuilder sbProgram = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        while ((value = is.read()) != -1) {
            sbProgram.append(String.format("%02X ", value));
            if (bytesCounter == 15) {
                sbResult.append(sbProgram).append("\n");
                sbProgram.setLength(0);
                bytesCounter = 0;
            } else {
                bytesCounter++;
            }
        }
        if (bytesCounter != 0) {
            for (; bytesCounter < 16; bytesCounter++) {
                sbProgram.append("   ");
            }
            sbResult.append(sbProgram).append("\n");
        }
        StringBuilder deneme = sbResult;
        is.close();
        return deneme;
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.run();

    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please type the path you'd like to scan:");
        String path = scan.nextLine();
        signature(path);
    }

    public void signature(String path) {
        String extension;
        StringBuilder program = null;
        File folder = new File(path);
        File[] files = folder.listFiles();
        if (files.length == 0) {
            System.out.println("This folder is empty. Please choose a folder that is not empty!!");
        } else {
            for (File file : files) {
                String newPath = path + "\\" + file.getName();
                extension = newPath.substring(newPath.lastIndexOf(".") + 1);
                System.out.println("FILE NAME IS " + file);
                try {
                    program = convertToProgram(new File(newPath));
                    if (!extension.equalsIgnoreCase("txt")) {
                    }
                } catch (IOException ex) {
                }
                newPath = path;
            }
        }
    }

    public void match(List programDB, List extDB, List description, StringBuilder program, String ext, String file) {
        int counter = 0;
        for (int i = 0; i < programDB.size(); i++) {
            String control = program.substring(0, programDB.get(i).toString().length());
            if (control.equalsIgnoreCase(programDB.get(i).toString())) {
                if (!extDB.get(i).toString().equalsIgnoreCase(ext)) {
                    System.out.println("\u001b[41mDoesn't Match!!");
                    System.out.println("\u001b[41mReal extension :" + extDB.get(i));
                    // writeHTML(file,ext,extDB.get(i).toString(),description.get(i).toString());
                } else {
                    System.out.println("\u001b[42mEverything is OK!! There is no manipulation!!");
                    // writeHTML(file,ext,extDB.get(i).toString(),description.get(i).toString());
                }
            } else {
                counter++;
            }
            if (counter == programDB.size()) {
                System.out.println("\u001b[41mThe signature couldn't found int txt!");
            }
        }

    }
}