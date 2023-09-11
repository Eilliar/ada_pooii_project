package service;

import java.util.Scanner;

public class Menu {

    public void runUserInterface() {
        Scanner scanner = new Scanner(System.in);
        VehicleMenu vMenu = new VehicleMenu();
        int chosenOption;
        do {
            System.out.println("\nMenu:");
            System.out.println("0. Register New Vehicle");
            System.out.println("1. Edit Vehicle Registry");
            System.out.println("2. Search Vehicle");
            System.out.println("3. Register Client");
            System.out.println("4. Alter Client Registry");
            System.out.println("5. Rent Vehicle");
            System.out.println("6. Return Rented Vehicle");
            System.out.println("7. Quit");
            System.out.print("Choose an option: ");
            chosenOption = scanner.nextInt();
            scanner.nextLine(); //Clear buffer
            switch (chosenOption) {
                case 0:
                    vMenu.RegisterNewVehicle(scanner);
                    break;
                case 1:
                    vMenu.EditVehicle(scanner);
                    break;
                case 2:
                    vMenu.SearchVehicle(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }while(chosenOption != 7);
    }
}
