package edu.school21.chat.repositories;
import edu.school21.chat.models.Chatroom;
import java.util.Optional;
import java.sql.SQLException;
public interface ChatroomRepository {
    Optional<Chatroom> findById(Long id) throws SQLException;
}
