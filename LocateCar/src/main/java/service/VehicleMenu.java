package service;

import entity.VEHICLE_CATEGORY;
import entity.Vehicle;
import repository.VehicleRepository;

import java.util.Scanner;

public class VehicleMenu implements IEntityMenu{

    private VehicleRepository vehicleRepository = new VehicleRepository();

    @Override
    public boolean RegisterNew(Scanner scanner){
        System.out.println("Give the vehicle plate:");
        String plate = scanner.nextLine();
        if(this.vehicleRepository.search(plate) != null){
            System.out.println("Vehicle already registered, check the plate.");
            return false;
        }
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
        } while(categoryId < 0 | categoryId > VEHICLE_CATEGORY.values().length);
        VEHICLE_CATEGORY vehicleCategory = VEHICLE_CATEGORY.values()[categoryId];

        this.vehicleRepository.register(new Vehicle(plate, model, model_year, vehicleCategory));

        System.out.println(this.vehicleRepository);
        return true;
    }

    private Vehicle InternalSearch(Scanner scanner){
        System.out.println("Give me a plate to search for:");
        String plate = scanner.nextLine();
        return this.vehicleRepository.search(plate);
    }

    @Override
    public boolean EditRegister(Scanner scanner){
        Vehicle vehicle = this.InternalSearch(scanner);
        if(vehicle == null){
            System.out.println("No vehicle found with this plate.");
            return false;
        }
        System.out.printf("Found the following vehicle: %s\n", vehicle);
        String info;

        System.out.printf("Give me the vehicle model (ENTER to skip):");
        info = scanner.nextLine();
        String model = vehicle.getModel();
        if(!info.isEmpty()) {
            model = info;
        }

        System.out.println("Give me the vehicle year (ENTER to skip):");
        info = scanner.nextLine();
        int model_year = vehicle.getModel_year();
        if(!info.isEmpty()){
            model_year = Integer.valueOf(info);
        }


        VEHICLE_CATEGORY vehicleCategory = vehicle.getCategory();
        boolean skip = false;
        int categoryId = -1;
        do {
            System.out.println("Choose one of the categories bellow (ENTER to skip):");
            for (int i=0; i < VEHICLE_CATEGORY.values().length; i++){
                System.out.printf("\t%d. %s\n", i, VEHICLE_CATEGORY.values()[i]);
            }
            info = scanner.nextLine();
            if(info.isEmpty()){
                skip = true;
            }else{
                categoryId = Integer.valueOf(info);
            }
            if(categoryId > 0 & categoryId < VEHICLE_CATEGORY.values().length){
                vehicleCategory = VEHICLE_CATEGORY.values()[categoryId];
                skip = true;
            }
        } while(!skip);

        this.vehicleRepository.edit(new Vehicle(vehicle.getPlate(), model, model_year, vehicleCategory));

        return true;
    }

    @Override
    public void SearchRegister(Scanner scanner){
        Vehicle vehicle = this.InternalSearch(scanner);
        if(vehicle == null){
            System.out.println("No vehicle found with this plate.");
        }else {
            System.out.println(vehicle);
        }
    }

}
