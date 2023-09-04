import repository.H2DB;
import service.Menu;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        H2DB db = new H2DB();

        try {
            db.initializeDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
