package repository;

import java.sql.SQLException;

public class H2DB implements DB {

    JDBC jdbc = new JDBC("jdbc:h2:file:./LocateCar;DB_CLOSE_DELAY=-1", "ada", "santander");

    @Override
    public void initializeDB() throws SQLException {
        String createVehicleSQL = """
                CREATE TABLE IF NOT EXISTS vehicles (\s
                   id INT auto_increment PRIMARY KEY,\s
                   plate VARCHAR(50) NOT NULL,\s
                   type VARCHAR(50) NOT NULL,\s
                   model VARCHAR(50) NOT NULL,\s
                   model_year INT NOT NULL
                );""";

        System.out.println("[H2 Database] Creating vehicles table...");
        this.createTable(createVehicleSQL, jdbc);
        System.out.println("[H2 Database] Successfully created vehicles table!");

    }

    @Override
    public void insertRegister() throws SQLException {
        return;
    }
}
