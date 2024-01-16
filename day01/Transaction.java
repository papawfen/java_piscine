package task;

import java.util.UUID;

enum Category {
    DEBITS,
    CREDITS
};

public class Transaction {

    Transaction(User recipient, User sender, Category category, Integer amount, UUID id) {
        this.id = id;
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = category;
        this.transferAmount = amount;
    }

    public User getRecipient() { return recipient; }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Category getTransferCategory() {
        return transferCategory;
    }

    public void setTransferCategory(Category transferCategory) {
        this.transferCategory = transferCategory;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Integer transferAmount) {
        this.transferAmount = transferAmount;
    }

    public UUID getId() { return id; }

    private UUID id;
    private User recipient;
    private User sender;
    private Category transferCategory;
    private Integer transferAmount;
}
