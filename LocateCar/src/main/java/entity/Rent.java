package entity;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Rent {
    private int id;
    private final String place;
    private final LocalDateTime pickupDateTime;
    private LocalDateTime deliveryDateTime;
    private final Client client;
    private final Vehicle vehicle;
    private double charge = 0.0;
    private double base_rate = 0.0;
    private boolean isActive;

    public Rent(String place, Client client, Vehicle vehicle) {
        this.place = place;
        this.pickupDateTime = LocalDateTime.now();
        this.client = client;
        this.vehicle = vehicle;
        this.isActive = true;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isActive() {
        return isActive;
    }

    void endRent(LocalDateTime deliveryDateTime){
        this.deliveryDateTime = deliveryDateTime;
        this.calculateCharge();
        this.isActive = false;
    }

    private void  calculateCharge(){
        Duration duration = Duration.between(this.deliveryDateTime, this.pickupDateTime);
        double daily = Math.ceil(duration.toHours()/24.0);

        this.base_rate = (daily * this.vehicle.getCategory().daily_rate);
        if (this.client.getCategory() == CLIENT_CATEGORY.PF & daily > CLIENT_CATEGORY.PF.minDaysToDiscount){
            this.charge = (1.0 - CLIENT_CATEGORY.PF.discount) * this.base_rate;
        }
        else if (this.client.getCategory() == CLIENT_CATEGORY.PJ & daily > CLIENT_CATEGORY.PJ.minDaysToDiscount){
            this.charge = (1.0 - CLIENT_CATEGORY.PJ.discount) * this.base_rate;
        }
        else {
            this.charge = this.base_rate;
        }
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", pickupDateTime=" + pickupDateTime +
                ", deliveryDateTime=" + deliveryDateTime +
                ", client=" + client +
                ", vehicle=" + vehicle +
                ", charge=" + charge +
                ", base_rate=" + base_rate +
                ", isActive=" + isActive +
                '}';
    }
}
