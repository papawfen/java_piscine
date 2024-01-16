package edu.school21.chat.app;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;
import edu.school21.chat.repositories.ChatroomRepositoryJdbcImpl;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.UserRepositoryJdbcImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Program {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "papawfen";
    private static final String DB_PWD = "";
    private static final String DB_SCHEMA = "/resources/schema.sql";
    private static final String DB_DATA = "/resources/data.sql";

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        Connection connection = connect();
        runInit(connection);

        UserRepositoryJdbcImpl userRep = new UserRepositoryJdbcImpl(connection);
        ChatroomRepositoryJdbcImpl chatRep = new ChatroomRepositoryJdbcImpl(connection, userRep);
        MessagesRepository msgRep = new MessagesRepositoryJdbcImpl(connection, userRep, chatRep);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message ID:");
        Long id = scanner.nextLong();
        System.out.println(msgRep.findById(id).orElse(null));
    }

    private static void runInit(Connection connection) throws FileNotFoundException {
        runQueriesFromFile(connection, DB_SCHEMA);
        runQueriesFromFile(connection, DB_DATA);
    }

    private static Connection connect() {
        Connection conn = null;
        try {
            conn = HikariConnect().getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private static void runQueriesFromFile(Connection connection, String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(
                new File(System.getProperty("user.dir") + "/src/ex01/Chat/src/" + filename))
                .useDelimiter(";");
        try {
            while (scanner.hasNext()) {
                connection.createStatement().execute(scanner.next().trim());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    private static HikariDataSource HikariConnect() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DB_URL);
        config.setUsername(DB_USER);
        config.setPassword(DB_PWD);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return (new HikariDataSource(config));
    }

}
