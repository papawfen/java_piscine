package task;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public class TransactionList {
    public TransactionList() {
        transactions = new LinkedList<>();
    }
    public void addTransaction(Transaction trans) {
        transactions.add(trans);
    }
    public void removeTransactionByID(UUID id) throws Exception {
        if (!transactions.removeIf(element -> element.getId().equals(id))) {
            throw new Exception("aboba cant find this ID");
        }
    }
    public Transaction[] transformToArray() {
        return transactions.toArray(new Transaction[0]);
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    private LinkedList<Transaction> transactions;
}
