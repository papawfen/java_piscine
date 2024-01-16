package edu.school21.chat.models;
import edu.school21.chat.models.*;
import java.util.List;
import java.util.Objects;


public class User {
    public User(long id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> rooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.rooms = rooms;
    }
    private long id;
    private String login;
    private String password;
    private final List<Chatroom> createdRooms;
    private final List<Chatroom> rooms;

    public long getId() { return id; }
    public String getLogin() { return login; }
    public String getPassword() { return password; }

    public void setId(long newId) { this.id = newId; }
    public void setLogin(String newLogin) { this.login = newLogin; }
    public void setPassword(String newPassword) { this.password = newPassword; }

    @Override
    public String toString() {
        return "Chatroom: { " +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && login.equals(user.login) && password.equals(user.password) && createdRooms.equals(user.createdRooms) && rooms.equals(user.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createdRooms, rooms);
    }
}