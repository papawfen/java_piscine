package ex02;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Desktop;

public class Program {

    public static void main(String[] args) throws IOException, InterruptedException {
        String tmp = args[0].split("=")[1];
        boolean flag = true;
        Runtime r = Runtime.getRuntime();
        ProcessBuilder p = new ProcessBuilder();
        String newPath = new String();
        while (true) {
            Scanner inputLine = new Scanner(System.in);
            String input = inputLine.nextLine();
            
            if (flag == true) {
                newPath = tmp;
                Path temp = Paths.get(tmp);
                p.directory(new File(temp.normalize().toString()));
                flag = false;
            }

            if (input.equals("exit")) break;
            
            if (input.equals("ls")) {
                p.command("bash", "-c", "ls -lh | awk '{print $9, $5}' ");
                Process process = p.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                printLs(p, reader);
            } else if (input.startsWith("cd")) {
                newPath += "/" + input.substring(3);
                String temp = newPath;
                newPath = changeDirectory(temp, p);
            } 
            else if (input.startsWith("mv")) {
                Path pathTo = Paths.get(input.split(" ")[2]);
                File from = new File(newPath.concat("/").concat(input.split(" ")[1]));
                File to = new File(newPath.concat("/").concat(pathTo.normalize().toString()));
                if (to.isDirectory()) {

                    File tmpTo = new File(pathTo.toString().concat("/").concat(input.split(" ")[1]));
                    to = tmpTo;
                    System.out.println(to.toString());
                } 
                try {
                    Files.move(from.toPath(), to.toPath());
                    System.out.println("Directory moved successfully.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (input.startsWith("open")) {
                Path pathOpen = Paths.get(input.split(" ")[1]);
                File openFile = new File(newPath.concat("/").concat(pathOpen.normalize().toString()));
                Desktop desktop = null;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                 } 
                 try {
                    desktop.open(openFile);
             } catch (IOException e) {
               System.out.println(e);
             } 
            }
        }
    }

    public static String changeDirectory(String path, ProcessBuilder p) {
            Path newPath = Paths.get(path);
            p.directory(new File(newPath.normalize().toString()));
            return newPath.normalize().toString();
    }

    public static void printLs(ProcessBuilder p, BufferedReader reader) {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}