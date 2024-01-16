package task;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Menu {
    public Menu() { service = new TransactionService(); }
    public void consoleMenu() throws Exception {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        System.out.println("5. DEV – remove a transfer by ID");
        System.out.println("6. DEV – check transfer validity");
        System.out.println("7. Finish execution");
        Scanner scan = new Scanner(System.in);
        int next = scan.nextInt();
        switch(next) {
            case 1:
                add(scan);
                break;
            case 2:
                viewBalance(scan);
                break;
            case 3:
                performTransfer(scan);
                break;
            case 4:
                showAllTransactions(scan);
                break;
            case 5:

        }
    }

    private void add(Scanner scan) {
        System.out.println("Enter a user name and a balance");
        String line = scan.nextLine();
        String name = line.split(" ")[0];
        int balance = Integer.parseInt(line.split(" ")[1]);
        service.addUser(name, balance);
        System.out.print("User with id = %d is added");
    }

    private void viewBalance(Scanner scan) throws Exception {
        System.out.println("Enter a user ID");
        String ID = scan.nextLine();
        UUID id = UUID.fromString(ID);
        System.out.println(service.getUserByID(id).getName() + " - " + service.getUserBalance(id));
    }

    private void performTransfer(Scanner scan) throws Exception {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        String line = scan.nextLine();
        String recipient = line.split(" ")[0];
        String sender = line.split(" ")[1];
        int amount = Integer.parseInt(line.split(" ")[2]);
        service.makeTransaction(UUID.fromString(recipient), UUID.fromString(sender), amount);
        System.out.println("The transfer is completed");
    }

    private void showAllTransactions(Scanner scan) throws Exception {
        System.out.println("Enter a user ID");
        String line = scan.nextLine();
        System.out.println(Arrays.toString(service.getTransfers(service.getUserByID(UUID.fromString(line)))));
    }

    private TransactionService service;

}
