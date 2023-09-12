package repository;

import entity.Rent;
import entity.Vehicle;

import java.util.HashSet;
import java.util.Set;

public class RentRepository implements IRepository<Rent>{

    Set<Rent> rents = new HashSet<>();
    private int numberOfRents = 0;

    @Override
    public boolean register(Rent rent) {
        boolean contains = false;
        for(Rent r: this.rents){
            if(r.isActive()) {
                contains = rent.getClient().getDocument() == r.getClient().getDocument() |
                        rent.getVehicle().getPlate() == r.getVehicle().getPlate();

                if (contains) {
                    System.out.println("Unable to rent, either the Client or Vehicle already has active Rent.");
                    return false;
                }
            }
        }
        rent.setId(numberOfRents);
        this.rents.add(rent);
        numberOfRents += 1;
        return true;
    }

    @Override
    public Rent search(String keyword) {
        return null;
    }

    @Override
    public void edit(Rent rent) {

    }

    @Override
    public String toString() {
        String result = "";
        for (Rent t : this.rents) {
            result += "\n" + t.toString();
        }
        return result;
    }
}
