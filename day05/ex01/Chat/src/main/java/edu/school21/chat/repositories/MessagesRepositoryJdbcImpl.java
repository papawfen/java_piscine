package edu.school21.chat.repositories;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;
import java.util.Optional;
import java.util.ArrayList;
import java.sql.*;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final Connection dataSource;
    UserRepositoryJdbcImpl userRepository;
    ChatroomRepositoryJdbcImpl chatroomRepository;

    public MessagesRepositoryJdbcImpl(Connection dataSource, UserRepositoryJdbcImpl ur, ChatroomRepositoryJdbcImpl cr) {
        this.dataSource = dataSource;
        this.userRepository = ur;
        this.chatroomRepository = cr;
    }

    @Override
    public Optional<Message> findById(Long id) {
        Message ret = null;
        ResultSet resultSet = null;

        try {
            PreparedStatement query = dataSource.prepareStatement("SELECT * FROM chat.rooms WHERE id=" + id);
            query.setLong(1, id);
            resultSet = query.executeQuery();
            if (resultSet.next()) {
                ret = new Message(
                        resultSet.getLong("message_id"),
                        userRepository.findById(resultSet.getLong("author")).orElse(null),
                        chatroomRepository.findById(resultSet.getLong("room")).orElse(null),
                        resultSet.getString("text"),
                        resultSet.getTimestamp("timestamp").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (Optional.ofNullable(ret));
    }
}
