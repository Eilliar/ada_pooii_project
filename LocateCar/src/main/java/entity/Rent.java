package entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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

    public void endRent(LocalDateTime deliveryDateTime){
        this.deliveryDateTime = deliveryDateTime;
        this.calculateCharge();
        this.isActive = false;
    }

    private void  calculateCharge(){
        long daily = ChronoUnit.DAYS.between(this.pickupDateTime, this.deliveryDateTime);
        if(this.deliveryDateTime.isAfter(this.pickupDateTime.plusDays(daily))){
            daily += 1; // if hour:min is before pickup, add 1 daily
        }
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
                ", \n\tclient=" + client +
                ", \n\tvehicle=" + vehicle +
                ", \n\tcharge=" + charge +
                ", base_rate=" + base_rate +
                ", isActive=" + isActive +
                '}';
    }
}
