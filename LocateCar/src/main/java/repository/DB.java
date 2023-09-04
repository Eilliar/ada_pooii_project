package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public interface DB {

    record JDBC(String URL, String Username, String Password) {
    }

    private Connection getConnection(JDBC jdbc) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbc.URL, jdbc.Username, jdbc.Password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    default void createTable(String createTableSQL, JDBC jdbc) throws SQLException {
        try (Connection connection = this.getConnection(jdbc);
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    void initializeDB() throws SQLException;

    void insertRegister() throws SQLException;
}
