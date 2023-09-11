package entity;

public class Vehicle {

    private int id;
    private final String plate;
    private final String model;
    private final int model_year;
    private final VEHICLE_CATEGORY category;

    public Vehicle(String plate, String model, int model_year, VEHICLE_CATEGORY category) {
        this.plate = plate;
        this.model = model;
        this.model_year = model_year;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public String getModel() {
        return model;
    }

    public int getModel_year() {
        return model_year;
    }

    public VEHICLE_CATEGORY getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                ", model_year=" + model_year +
                ", category=" + category +
                '}';
    }
}
