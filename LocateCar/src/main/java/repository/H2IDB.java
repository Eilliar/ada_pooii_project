package repository;

import java.sql.SQLException;

public class H2IDB implements IDB {

    JDBC jdbc = new JDBC("jdbc:h2:file:./LocateCar;DB_CLOSE_DELAY=-1", "ada", "santander");

    @Override
    public void initializeDB() throws SQLException {
        String createVehicleTypeSQL = """
                CREATE TABLE IF NOT EXISTS vehicle_category (\s
                   id INT auto_increment PRIMARY KEY,\s
                   category VARCHAR(50) NOT NULL,\s
                   daily_rate NUMERIC NOT NULL,\s
                   currency VARCHAR(3) NOT NULL
                );""";
        System.out.println("[H2 Database] Creating vehicle_category table...");
        this.createTable(createVehicleTypeSQL, jdbc);
        System.out.println("[H2 Database] Successfully created vehicle_category table!");

        String createVehicleSQL = """
                CREATE TABLE IF NOT EXISTS vehicles (\s
                   id INT auto_increment PRIMARY KEY,\s
                   plate VARCHAR(50) NOT NULL,\s
                   model VARCHAR(50) NOT NULL,\s
                   model_year INT NOT NULL,\s
                   category_id INT NOT NULL,\s
                   
                   FOREIGN KEY (category_id) REFERENCES vehicle_category(id)
                );""";
        System.out.println("[H2 Database] Creating vehicles table...");
        this.createTable(createVehicleSQL, jdbc);
        System.out.println("[H2 Database] Successfully created vehicles table!");

        String createClientSQL = """
                CREATE TABLE IF NOT EXISTS clients (\s
                   id INT auto_increment PRIMARY KEY,\s
                   name VARCHAR(50) NOT NULL,\s
                   category VARCHAR(2) NOT NULL,\s
                   document VARCHAR(50) NOT NULL\s
                );""";
        System.out.println("[H2 Database] Creating clients table...");
        this.createTable(createClientSQL, jdbc);
        System.out.println("[H2 Database] Successfully created clients table!");


    }

//    @Override
//    public void insertRegister(String insertIntoSQL, JDBC jdbc) throws SQLException {
//    }
}
