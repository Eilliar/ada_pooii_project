package service;

import java.util.Scanner;

public class Menu {

    public void runUserInterface() {
        Scanner scanner = new Scanner(System.in);
        IEntityMenu vMenu = new VehicleMenu();
        IEntityMenu cMenu = new ClientMenu();
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
                    vMenu.RegisterNew(scanner);
                    break;
                case 1:
                    vMenu.EditRegister(scanner);
                    break;
                case 2:
                    vMenu.SearchRegister(scanner);
                    break;
                case 3:
                    cMenu.RegisterNew(scanner);
                    break;
                case 4:
                    cMenu.EditRegister(scanner);
                    break;
                case 5:
                    cMenu.SearchRegister(scanner);
                    break;
                case 6:
                    break;
                case 7:
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
