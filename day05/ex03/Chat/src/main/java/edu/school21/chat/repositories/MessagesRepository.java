package edu.school21.chat.repositories;
import edu.school21.chat.models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface MessagesRepository {

    Optional<Message> findById(Long id) throws SQLException;
    void save(Message message);
    public void update(Message message);
}






