package task;

import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User("aboba", 500);
        User user1 = new User("amogus", 1000);
        User user2 = new User("sugoma", 1000);
        User user3 = new User("abigus", 1000);
        UsersList list = new UsersList();
        list.addUser(user);
        list.addUser(user1);
        list.addUser(user2);
        list.addUser(user3);
        String flag = args[0].split("=")[1];
        if (flag.equals("dev")) {

        }
    }
}