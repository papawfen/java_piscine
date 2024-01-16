package task;
import java.util.UUID;

public class User {

    User (String name, Integer balance) {
        id = UserIdsGenerator.getInstance().generateUUID();
        this.name = name;
        this.balance = balance;
    }

    public UUID getId() { return id; }
    public void setName(String name) { this.name = name; }
    public void setBalance(Integer newBalance) { balance = newBalance; }
    public String getName() { return name; }
    public Integer getBalance() { return balance; }
    private UUID id;
    private String name;
    private Integer balance;
}
