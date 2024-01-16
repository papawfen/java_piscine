package task;
import java.util.ArrayList;
import java.util.UUID;

import static task.Category.*;

public class TransactionService {

    public TransactionService() {
        transList = new TransactionList();
        list = new UsersList();
    }
    public void addUser(String name, Integer balance) {
        User user = new User(name, balance);
        list.addUser(user);
    }
    public Integer getUserBalance(UUID id) throws Exception {
        return list.findUserById(id).getBalance();
    }
    public Integer getUserBalance(Integer id) throws Exception {
        return list.findUserByIndex(id).getBalance();
    }
    public void makeTransaction(UUID recipientID, UUID senderID, Integer amount) throws Exception {
        UUID id = UserIdsGenerator.getInstance().generateTranscationUUID();
        if (list.findUserById(senderID).getBalance() - amount < 0) throw new Exception("IllegalTransactionException");
        Transaction transaction1 = new Transaction(list.findUserById(senderID), list.findUserById(recipientID), CREDITS, -amount, id);
        Transaction transaction = new Transaction(list.findUserById(recipientID), list.findUserById(senderID), DEBITS, amount, id);
        list.findUserById(senderID).setBalance(list.findUserById(senderID).getBalance() - amount);
        list.findUserById(recipientID).setBalance(list.findUserById(recipientID).getBalance() + amount);
        transList.addTransaction(transaction);
        transList.addTransaction(transaction1);
    }
    public Transaction[] getTransfers(User user) {
        ArrayList<Transaction> userTransactions = new ArrayList<>();
        for (Transaction it : transList.getTransactions()) {
            if (it.getRecipient().getId().equals(user.getId())) userTransactions.add(it);
        }
        return userTransactions.toArray(new Transaction[0]);
    }
    public void removeTransaction(UUID userID, UUID transactionID) {
        transList.getTransactions().removeIf(element -> element.getRecipient().getId().equals(userID) && element.getId().equals(transactionID));
    }

    public User getUserByID(UUID id) throws Exception {
        for (User it : list.getUsers()) {
            if (it.getId().equals(id)) return it;
        }
        throw new Exception("user not found");
    }
    public void checkValidity() {
      System.out.println("TODO");
    }
    UsersList list;
    TransactionList transList;
}
