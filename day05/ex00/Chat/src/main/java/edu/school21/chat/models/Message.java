package edu.school21.chat.models;
import edu.school21.chat.models.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {

    public Message(long id, User author, Chatroom chatroom, String text, LocalDateTime messageDateTime) {
        this.id = id;
        this.author = author;
        this.room = chatroom;
        this.text = text;
        this.dateTime = messageDateTime;
    }
    private long id;
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime dateTime;

    public long getId() { return id; }
    public User getAuthor() { return author; }
    public Chatroom getRoom() { return room; }
    public String getText() { return text; }
    public LocalDateTime getDateTime() { return dateTime; }

    public void setId(long newId) { id = newId; }
    public void setAuthor(User newAuthor) { author = newAuthor; }
    public void setRoom(Chatroom newRoom) { room = newRoom; }
    public void setText(String newText) { text = newText; }
    public void setDateTime(LocalDateTime newDate) { dateTime = newDate; }

    @Override
    public String toString() {
        return "Chatroom: { " +
                "id=" + id +
                ", author='" + author + '\'' +
                ", room='" + room + '\'' +
                ", text='" + text + '\'' +
                ", date time='" + dateTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && author.equals(message.author) && room.equals(message.room) && text.equals(message.text) && dateTime.equals(message.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room, text, dateTime);
    }
}