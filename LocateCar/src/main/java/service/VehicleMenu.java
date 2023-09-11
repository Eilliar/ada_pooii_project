package service;

import entity.VEHICLE_CATEGORY;
import entity.Vehicle;
import repository.VehicleRepository;

import java.util.Scanner;

public class VehicleMenu {

    private VehicleRepository vehicleRepository = new VehicleRepository();

    boolean RegisterNewVehicle(Scanner scanner){
        System.out.println("Give the vehicle plate:");
        String plate = scanner.nextLine();
        System.out.println("Give me the vehicle model:");
        String model = scanner.nextLine();
        System.out.println("Give me the vehicle year:");
        int model_year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Choose one of the categories bellow:");
        int categoryId;
        do {
            for (int i=0; i < VEHICLE_CATEGORY.values().length; i++){
                System.out.printf("\t%d. %s\n", i, VEHICLE_CATEGORY.values()[i]);
            }
            categoryId = scanner.nextInt();
            System.out.println("Invalid category number, try again.");
        } while(categoryId < 0 | categoryId > VEHICLE_CATEGORY.values().length);
        VEHICLE_CATEGORY vehicleCategory = VEHICLE_CATEGORY.values()[categoryId];

        Vehicle vehicle = new Vehicle(plate, model, model_year, vehicleCategory);

        if(!this.vehicleRepository.register(vehicle)){
            System.out.println("Vehicle already registered, check the plate.");
        }

        System.out.println(this.vehicleRepository);
        return true;
    }

}
