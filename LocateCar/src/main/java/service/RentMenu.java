package service;

import entity.Client;
import entity.Rent;
import entity.Vehicle;
import repository.ClientRepository;
import repository.RentRepository;
import repository.VehicleRepository;

import java.util.Scanner;

public class RentMenu implements IEntityMenu{

    RentRepository rentRepository;
    VehicleRepository vehicleRepository;
    ClientRepository clientRepository;

    public RentMenu(RentRepository rentRepository, VehicleRepository vehicleRepository, ClientRepository clientRepository) {
        this.rentRepository = rentRepository;
        this.vehicleRepository = vehicleRepository;
        this.clientRepository = clientRepository;
    }

    @Override
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

    @Override
    public boolean EditRegister(Scanner scanner) {
        return false;
    }

    @Override
    public void SearchRegister(Scanner scanner) {

    }
}
