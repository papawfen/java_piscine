package edu.school21.chat.models;
import edu.school21.chat.models.*;
import java.util.List;
import java.util.Objects;

public class Chatroom {

    public Chatroom(long id, String name, User owner, List<Message> roomMessages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.roomMessages = roomMessages;
    }
    private long id;
    private String name;
    private User owner;
    private final List<Message> roomMessages;

    public long getId() { return id; }
    public String getName() { return name; }
    public User getOwner() { return owner; }

    public void setId(long newId) { id = newId; }
    public void setName(String newName) { name = newName; }
    public void setOwner(User newOwner) { owner = newOwner; }

    @Override
    public String toString() {
        return "Chatroom: { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return id == chatroom.id && name.equals(chatroom.name) && owner.equals(chatroom.owner) && roomMessages.equals(chatroom.roomMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, roomMessages);
    }
}