package service;

import repository.ClientRepository;
import repository.RentRepository;
import repository.VehicleRepository;

import java.util.Scanner;

public class Menu {
    private IEntityMenu vehicleMenu;
    private IEntityMenu clientMenu;
    private RentMenu rentMenu;
    private Scanner scanner = new Scanner(System.in);
    public Menu() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        ClientRepository clientRepository = new ClientRepository();
        RentRepository rentRepository = new RentRepository();
        this.vehicleMenu = new VehicleMenu(vehicleRepository);
        this.clientMenu = new ClientMenu(clientRepository);
        this.rentMenu = new RentMenu(rentRepository, vehicleRepository, clientRepository);
    }

    public void runUserInterface() {
        int chosenOption;
        do {
            System.out.println("\nMenu:");
            System.out.println("0. Register New Vehicle");
            System.out.println("1. Edit Vehicle Registry");
            System.out.println("2. Search Vehicle");
            System.out.println("3. Register Client");
            System.out.println("4. Edit Client Registry");
            System.out.println("5. Search Client");
            System.out.println("6. Rent Vehicle");
            System.out.println("7. Return Rented Vehicle");
            System.out.println("8. Quit");
            System.out.print("Choose an option: ");
            chosenOption = scanner.nextInt();
            scanner.nextLine(); //Clear buffer
            switch (chosenOption) {
                case 0:
                    vehicleMenu.RegisterNew(scanner);
                    break;
                case 1:
                    vehicleMenu.EditRegister(scanner);
                    break;
                case 2:
                    vehicleMenu.SearchRegister(scanner);
                    break;
                case 3:
                    clientMenu.RegisterNew(scanner);
                    break;
                case 4:
                    clientMenu.EditRegister(scanner);
                    break;
                case 5:
                    clientMenu.SearchRegister(scanner);
                    break;
                case 6:
                    rentMenu.RegisterNew(scanner);
                    break;
                case 7:
                    rentMenu.ReturnVehicle(scanner);
                    break;
                case 8:
                    System.out.println("Ok, bye.");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }while(chosenOption != 8);
    }
}
