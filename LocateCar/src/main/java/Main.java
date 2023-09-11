import entity.VEHICLE_CATEGORY;
import entity.Vehicle;
import repository.H2IDB;
import repository.VehicleRepository;
import service.Menu;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
//        H2IDB db = new H2IDB();
//
//        try {
//            db.initializeDB();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        Menu menu = new Menu();

        menu.runUserInterface();

    }
}
