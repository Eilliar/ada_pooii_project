package repository;

import java.sql.*;

public interface IDB {

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

//    default ResultSet insertRegister(PreparedStatement insertStatement, JDBC jdbc) throws SQLException {
//        try (Connection connection = this.getConnection(jdbc)) {
//            insertStatement.executeUpdate();
//            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
//
//            return generatedKeys;
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }

    void initializeDB() throws SQLException;


}
