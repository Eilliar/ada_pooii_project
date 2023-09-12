package service;

import entity.Client;
import entity.Rent;
import entity.Vehicle;
import repository.ClientRepository;
import repository.RentRepository;
import repository.VehicleRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RentMenu{

    RentRepository rentRepository;
    VehicleRepository vehicleRepository;
    ClientRepository clientRepository;

    public RentMenu(RentRepository rentRepository, VehicleRepository vehicleRepository, ClientRepository clientRepository) {
        this.rentRepository = rentRepository;
        this.vehicleRepository = vehicleRepository;
        this.clientRepository = clientRepository;
    }

    public boolean RegisterNew(Scanner scanner) {
        System.out.println("Give me the client document to search for:");
        String document = scanner.nextLine();
        Client client = clientRepository.search(document);
        if(client == null){
            System.out.println("Unable to locate the client.");
            return false;
        }
        System.out.println("Give me a vehicle plate to search for:");
        String plate = scanner.nextLine();
        Vehicle vehicle = vehicleRepository.search(plate);
        if(vehicle == null){
            System.out.println("Unable to locate the vehicle.");
            return false;
        }
        System.out.println("Give me a pickup location:");
        String location = scanner.nextLine();

        Rent rent = new Rent(location, client, vehicle);
        rentRepository.register(rent);

        System.out.println(rentRepository);
        return true;
    }

    public boolean ReturnVehicle(Scanner scanner){
        System.out.println("Give me the Vehicle's plate:");
        String plate = scanner.nextLine();

        Rent rent = this.rentRepository.search(plate);
        if(rent == null){
            System.out.println("Unable to locate an active rent for this vehicle");
            return false;
        }

        System.out.println("Give me the returning date and time (yyyy-MM-dd HH:mm):");
        String inputDateTime = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime returningDateTime = LocalDateTime.parse(inputDateTime, formatter);

        rent.endRent(returningDateTime);
        System.out.println(rentRepository);

        return true;
    }
}
