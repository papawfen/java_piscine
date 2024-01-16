package edu.school21.chat.repositories;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;
import edu.school21.chat.exceptions.*;
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
        final String queryTmp = "SELECT * FROM public.message WHERE message_id=";
        Message ret = null;
        ResultSet resultSet = null;

        try {
            PreparedStatement query = dataSource.prepareStatement(queryTmp);
            query.setLong(1, id);
            resultSet = query.executeQuery();
            if (resultSet.next()) {
                ret = new Message(
                        resultSet.getLong("id"),
                        userRepository.findById(resultSet.getLong("author")).orElse(null),
                        chatroomRepository.findById(resultSet.getLong("room")).orElse(null),
                        resultSet.getString("text"),
                        resultSet.getTimestamp("date").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (Optional.ofNullable(ret));
    }

    @Override
    public void save(Message message) {
        final String queryTmp = "INSERT INTO public.message (author, room, text, date) VALUES (?, ?, ?, ?) RETURNING *";
        ResultSet resultSet = null;
        try {
            if (userRepository.findById(message.getAuthor().getId()).isPresent()
                    && chatroomRepository.findById(message.getRoom().getId()).isPresent()) {
                PreparedStatement query = dataSource.prepareStatement(queryTmp);
                query.setLong(1, message.getAuthor().getId());
                query.setLong(2, message.getRoom().getId());
                query.setString(3, message.getText());
                query.setTimestamp(4, Timestamp.valueOf(message.getDateTime()));
                resultSet = query.executeQuery();
                resultSet.next();
                message.setId(resultSet.getLong("message_id"));
            } else {
                throw new NotSavedSubEntityException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
        public void update(Message message) {
            final String queryTmp = "UPDATE public.message SET author =?, room =?, text =?, date =? WHERE message_id =?";
            try {
                PreparedStatement query = dataSource.prepareStatement(queryTmp);
                query.setLong(1, message.getAuthor().getId());
                query.setLong(2, message.getRoom().getId());
                query.setString(3, message.getText());
                try {
                    query.setTimestamp(4, Timestamp.valueOf(message.getDateTime()));
                } catch (NullPointerException e)	{
                    query.setTimestamp(4, null);
                }
                query.setLong(5, message.getId());
                query.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
