package repository;

import entity.Vehicle;

import java.util.HashSet;
import java.util.Set;

public class VehicleRepository implements IRepository<Vehicle> {

    Set<Vehicle> vehicles = new HashSet<>();
    private static int numberOfVehicles = 0;

    @Override
    public boolean register(Vehicle vehicle) {
        boolean contains = false;
        for (Vehicle v : this.vehicles) {
            if (v.getPlate().equalsIgnoreCase(vehicle.getPlate())) {
                contains = true;
                break;
            }
        }
        if (!contains) {
            vehicle.setId(numberOfVehicles);
            this.vehicles.add(vehicle);
            numberOfVehicles += 1;
        }
        return !contains;
    }

    @Override
    public Vehicle search(String plate) {
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getPlate().equalsIgnoreCase(plate)) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for (Vehicle v : this.vehicles) {
            result += "\n" + v.toString();
        }
        return result;
    }
}
