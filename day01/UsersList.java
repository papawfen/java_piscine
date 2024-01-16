package task;

import java.util.ArrayList;
import java.util.UUID;

public class UsersList {
    public UsersList() {
        users = new ArrayList<User>(10);
    }
    public void addUser(User user) {
        users.add(user);
    }
    public User findUserById(UUID id) throws Exception {
        for (User it : users) {
            if (it.getId().equals(id)) return it;
        }
        throw new Exception("UserNotFoundException");
    }
    public User findUserByIndex(int idx) throws Exception {
        if (idx > users.size()) throw new Exception("UserNotFoundException");
        return users.get(idx);
    }
    public Integer getNUmberOfUsers() { return users.size(); }

    public ArrayList<User> getUsers() {
        return users;
    }

    private ArrayList<User> users;
}
